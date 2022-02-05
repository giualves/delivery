package com.devweb.delivery.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.devweb.delivery.dto.ClienteResumoDTO;
import com.devweb.delivery.entity.Cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteResumoOutputMapper {
	
    @Autowired
	private ModelMapper modelMapper;

    public ClienteResumoDTO mapearDTO(Cliente c) {
        ClienteResumoDTO clienteResumoDTO = modelMapper.map(c, ClienteResumoDTO.class);
        return clienteResumoDTO;
    }

    public List<ClienteResumoDTO> mapearLista(List<Cliente> clientes) {
        return clientes.stream()
            .map(cliente -> mapearDTO(cliente))
            .collect(Collectors.toList());
    }
}
