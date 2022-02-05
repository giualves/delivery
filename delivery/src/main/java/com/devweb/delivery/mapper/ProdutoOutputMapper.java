package com.devweb.delivery.mapper;

import com.devweb.delivery.dto.ProdutoDTO;
import com.devweb.delivery.entity.Produto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoOutputMapper {
    
    @Autowired
    private ModelMapper mapper;

    public ProdutoDTO mapearDTO(Produto p) {

        ProdutoDTO produtoDTO = mapper.map(p, ProdutoDTO.class);

        return produtoDTO;
        
    }

}
