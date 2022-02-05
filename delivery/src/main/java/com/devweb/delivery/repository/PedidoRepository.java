package com.devweb.delivery.repository;

import com.devweb.delivery.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>  {

    public Pedido findByUuid(String uuid);
}
