package com.devweb.delivery.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 150)
	private String email;
	
	@Column(name = "limite_credito", nullable = false)
	private BigDecimal limiteCredito;
	
	@Column(name = "uuid", length = 36)
	private String uuid;

	@PrePersist
	private void gerarUUID() {
		setUuid(UUID.randomUUID().toString());
	}

//	Se precisar manter a lista de clientes no restaurante
//	descomentar essas linhas...	
//	@Column(name = "res_idf", nullable = false)
//	private Long restaurante;
	
}
