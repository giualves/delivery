package com.devweb.delivery.mapper;

import com.devweb.delivery.dto.PedidoDTO;
import com.devweb.delivery.entity.Pedido;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoOutputMapper {

    @Autowired ModelMapper modelMapper;

    public PedidoDTO mapearDTO(Pedido ped) {

        PedidoDTO pedidoDTO = modelMapper.map(ped, PedidoDTO.class);

        return pedidoDTO;
    }
    
}
