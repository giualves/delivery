package com.devweb.delivery.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.devweb.delivery.dto.ProdutoResumoDTO;
import com.devweb.delivery.entity.Produto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResumoOutputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoResumoDTO mapearDTO(Produto p) {
        ProdutoResumoDTO produtoResumoDTO = modelMapper.map(p, ProdutoResumoDTO.class);
        return produtoResumoDTO;
    }

    public List<ProdutoResumoDTO> mapearLista(List<Produto> produtos) {
        return produtos.stream()
            .map(produto -> mapearDTO(produto))
            .collect(Collectors.toList());
    }
    
}
