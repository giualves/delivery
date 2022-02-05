package com.devweb.delivery.mapper;

import com.devweb.delivery.dto.ClienteDTO;
import com.devweb.delivery.entity.Cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteOutputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteDTO mapearDTO(Cliente c)  {
        
        ClienteDTO clienteDTO = modelMapper.map(c, ClienteDTO.class);
        
        return clienteDTO;

    }


    
}
