package com.devweb.delivery.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteDTO {

	private String uuid;
	
	private String nome;
	
	private BigDecimal taxaFrete;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}

	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}

}
