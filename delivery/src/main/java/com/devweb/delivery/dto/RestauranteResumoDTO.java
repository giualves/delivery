package com.devweb.delivery.dto;

import lombok.Data;

@Data
public class RestauranteResumoDTO {

	private String uuid;
	
	private String nome;

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

}
