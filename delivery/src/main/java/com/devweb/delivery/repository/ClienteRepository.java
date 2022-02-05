package com.devweb.delivery.repository;

import com.devweb.delivery.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    public Cliente findByUuid(String uuid);
}
