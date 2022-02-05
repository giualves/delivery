package com.devweb.delivery.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ClienteDTO {

	private String uuid;
	
	private String nome;
    
    private BigDecimal limiteCredito;

}
