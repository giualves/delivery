package com.devweb.delivery.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.devweb.delivery.dto.PedidoResumoDTO;
import com.devweb.delivery.entity.Pedido;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoResumoOutputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoResumoDTO mapearDTO(Pedido ped) {
        PedidoResumoDTO pedidoResumoDTO = modelMapper.map(ped, PedidoResumoDTO.class);
        return pedidoResumoDTO;
    }

    public List<PedidoResumoDTO> mapearLista(List<Pedido> pedidos) {
        return pedidos.stream()
            .map(pedido -> mapearDTO(pedido))
            .collect(Collectors.toList());
    }
    
}
