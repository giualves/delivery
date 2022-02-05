package com.devweb.delivery.repository;

import com.devweb.delivery.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public Produto findByUuid(String uuid);
    
}
