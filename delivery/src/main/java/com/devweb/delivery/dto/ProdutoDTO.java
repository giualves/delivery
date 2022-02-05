package com.devweb.delivery.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoDTO {

	private String uuid;
	
	private String nome;
    
    private BigDecimal preco;    
    
}
