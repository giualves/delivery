package com.devweb.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.delivery.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
