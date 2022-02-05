package com.devweb.delivery.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Data
@Entity
@Table(name = "pedido")
public class Pedido {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uuid", length = 36)
	private String uuid;

	
    @Column(name = "total", nullable = false)
	private BigDecimal total;

	@OneToOne
	@JoinColumn(name = "res_idf")
	private Restaurante restaurante;

    @OneToOne
	@JoinColumn(name = "cli_idf")   
    private Cliente cliente;       

	@OneToOne
	@JoinColumn(name = "user_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "pedido")
	@Cascade(CascadeType.DELETE)
	private List<PedidoItem> pedidoItem;
    
    @PrePersist
	private void gerarUUID() {
		setUuid(UUID.randomUUID().toString());
	}    
    
}
