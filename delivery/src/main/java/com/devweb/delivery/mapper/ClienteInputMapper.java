package com.devweb.delivery.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.devweb.delivery.dto.ClienteInputDTO;
import com.devweb.delivery.entity.Cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteInputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente mapearEntity(ClienteInputDTO clienteInputDTO) {

        Cliente c = modelMapper.map(clienteInputDTO, Cliente.class);
        
        return c;
    }

    public List<Cliente> mapearLista(List<ClienteInputDTO> clienteInputDTOs) {
        
        return clienteInputDTOs.stream()
            .map(clienteInputDTO -> mapearEntity(clienteInputDTO))
            .collect(Collectors.toList());
    }
    
}
