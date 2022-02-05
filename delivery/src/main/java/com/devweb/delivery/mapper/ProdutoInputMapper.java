package com.devweb.delivery.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.devweb.delivery.dto.ProdutoInputDTO;
import com.devweb.delivery.entity.Produto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoInputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Produto mapearEntity(ProdutoInputDTO produtoInputDTO) {
        Produto p = modelMapper.map(produtoInputDTO, Produto.class);

        return p;
    }

    public List<Produto> mapearLista(List<ProdutoInputDTO> produtoInputDTOs) {
        return produtoInputDTOs.stream()
            .map(produtoInputDTO -> mapearEntity(produtoInputDTO))
            .collect(Collectors.toList());
    }
    
    
}
