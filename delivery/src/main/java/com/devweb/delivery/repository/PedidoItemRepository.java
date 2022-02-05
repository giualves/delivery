package com.devweb.delivery.repository;

import com.devweb.delivery.entity.PedidoItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

    PedidoItem findByUuid(String uuid);
    
}
