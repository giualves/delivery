package com.devweb.delivery.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String nome;

	@Column(name = "preco", nullable = false)
	private BigDecimal preco;

    @Column(name = "uuid", length = 36)
	private String uuid;

	@PrePersist
	private void gerarUUID() {
		setUuid(UUID.randomUUID().toString());
	}
    
}
