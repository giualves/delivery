package com.devweb.delivery.entity;

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

import lombok.Data;

@Data
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "uuid", nullable = false)
	private String uuid;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "status", nullable = false)
	private Boolean status = Boolean.TRUE;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "res_idf")
	private Restaurante restaurante;
	
	public void ativar() {
		setStatus(true);
	}
	
	public void inativar() {
		setStatus(false);
	}
	
	private void setStatus(Boolean status) {
		this.status = status;
	}
	
	@PrePersist
	private void generateUUID() {
		setUuid(UUID.randomUUID().toString());
	}
	
}
