package com.devweb.delivery.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.devweb.delivery.dto.PedidoInputDTO;
import com.devweb.delivery.entity.Pedido;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoInputMapper {

    @Autowired
    private ModelMapper mapper;

    public Pedido mapearEntity(PedidoInputDTO pedidoInputDTO) {
        Pedido ped = mapper.map(pedidoInputDTO, Pedido.class);
        return ped;
    }

    public List<Pedido> mapearLista(List<PedidoInputDTO> pedidoInputDTOs) {
        return pedidoInputDTOs.stream()
            .map(pedidoInputDTO -> mapearEntity(pedidoInputDTO))
            .collect(Collectors.toList());
    }
    
}
