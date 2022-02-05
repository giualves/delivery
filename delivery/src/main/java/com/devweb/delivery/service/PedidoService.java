package com.devweb.delivery.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.devweb.delivery.dto.PedidoInputDTO;
import com.devweb.delivery.dto.PedidoItemInputDTO;
import com.devweb.delivery.entity.Cliente;
import com.devweb.delivery.entity.Pedido;
import com.devweb.delivery.entity.PedidoItem;
import com.devweb.delivery.entity.Restaurante;
import com.devweb.delivery.entity.Usuario;
import com.devweb.delivery.exception.NotFoundException;
import com.devweb.delivery.mapper.PedidoInputMapper;
import com.devweb.delivery.repository.PedidoItemRepository;
import com.devweb.delivery.repository.PedidoRepository;
import com.devweb.delivery.security.AuthenticatedUser;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired 
    private PedidoInputMapper pedidoInputMapper;
    @Autowired
    private PedidoItemRepository pedidoItemRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AuthenticatedUser aUser;
    @Autowired
    private ProdutoService produtoService;

    private Double nTotalPedido;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
    

    public Pedido getPedidoByUuid(String uuid) {
        Pedido ped = pedidoRepository.findByUuid(uuid);

        if (ped == null) {
            throw new NotFoundException("Pedido nao encontrado");
        }

        return ped;
    }

    public Pedido salvar(PedidoInputDTO pedidoInputDTO) {
    
        Pedido ped = pedidoInputMapper.mapearEntity(pedidoInputDTO);
        Cliente cli = clienteService.getClienteByUuid(pedidoInputDTO.getCli_uuid());
        ped.setCliente(cli);

        //buscar restaurante pelo usuario
        Usuario usuario = aUser.getUsuario();
        ped.setUsuario(usuario);
        Restaurante res = usuario.getRestaurante();
        ped.setRestaurante(res);
        ped.setTotal(BigDecimal.valueOf(0));
        

        pedidoRepository.save(ped);

        if (pedidoInputDTO.getPedidoItem() == null) {
            throw new NotFoundException("Não existem itens no pedido");
        }

        nTotalPedido = 0.0;

        ArrayList<PedidoItem> pedidoItems = new ArrayList<>();
        for (PedidoItemInputDTO pedidoItemInputDTO : pedidoInputDTO.getPedidoItem()) {
            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setProduto(produtoService.getProdutoByUuid(pedidoItemInputDTO.getProdUuid()));
            pedidoItem.setQuantidade(pedidoItemInputDTO.getQuantidade());
            pedidoItem.setPedido(ped);
            nTotalPedido = nTotalPedido + (pedidoItem.getProduto().getPreco().doubleValue() * pedidoItem.getQuantidade().doubleValue() );

            pedidoItems.add(pedidoItem);
        }
        pedidoItemRepository.saveAll(pedidoItems);
        ped.setPedidoItem(pedidoItems); 
        ped.setTotal(BigDecimal.valueOf(nTotalPedido));    
        pedidoRepository.save(ped);

        return ped;
    }

    public boolean excluir(String uuid) {
        Pedido ped = this.getPedidoByUuid(uuid);

        if (ped != null) {
            try {
                pedidoRepository.delete(ped);
                return true;
            } catch (EmptyResultDataAccessException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public Pedido alterar(String uuid, Pedido ped) {
        Pedido pedAtual = this.getPedidoByUuid(uuid);

        if (pedAtual != null) {
            BeanUtils.copyProperties(ped, pedAtual, "id", "uuid", "total");
            return pedidoRepository.save(pedAtual);
        }
        return null;
    }
}
