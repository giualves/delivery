package com.devweb.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import com.devweb.delivery.dto.PedidoDTO;
import com.devweb.delivery.dto.PedidoInputDTO;
import com.devweb.delivery.dto.PedidoResumoDTO;
import com.devweb.delivery.entity.Pedido;
import com.devweb.delivery.mapper.PedidoInputMapper;
import com.devweb.delivery.mapper.PedidoOutputMapper;
import com.devweb.delivery.mapper.PedidoResumoOutputMapper;
import com.devweb.delivery.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoInputMapper pedidoInputMapper;

    @Autowired
    private PedidoOutputMapper pedidoOutputMapper;

    @Autowired
    private PedidoResumoOutputMapper pedidoResumoOutputMapper;


    
    @GetMapping("/{uuid}")
    @ResponseBody
    public PedidoDTO getProdutoById(@PathVariable String uuid) {
        Pedido ped = pedidoService.getPedidoByUuid(uuid);
        PedidoDTO pedidoDTO = pedidoOutputMapper.mapearDTO(ped);
        return pedidoDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    private PedidoDTO adicionar(@RequestBody @Valid PedidoInputDTO pedidoInputDTO) {
        Pedido ped = pedidoInputMapper.mapearEntity(pedidoInputDTO);
        ped = pedidoService.salvar(pedidoInputDTO);
        PedidoDTO pedidoDTO = pedidoOutputMapper.mapearDTO(ped);
        return pedidoDTO;
        
    }

    @GetMapping
    @ResponseBody
    public List<PedidoResumoDTO> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        List<PedidoResumoDTO> pedidoResumoDTOs = pedidoResumoOutputMapper.mapearLista(pedidos);
        return pedidoResumoDTOs;
    }
    
    @DeleteMapping("/{uuid}")
    private ResponseEntity<Pedido> deletar(@PathVariable String uuid) {
        if (pedidoService.excluir(uuid)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }    

    @PutMapping("/{uuid}")
    @ResponseBody
    private PedidoDTO alterar(@PathVariable String uuid, @Valid @RequestBody PedidoInputDTO pedidoInputDTO) {
        Pedido ped = pedidoInputMapper.mapearEntity(pedidoInputDTO);
        ped = pedidoService.alterar(uuid, ped);
        PedidoDTO pedidoDTO = pedidoOutputMapper.mapearDTO(ped);
        return pedidoDTO;
    }

    

}
