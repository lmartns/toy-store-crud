package com.example.toy_store_crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, String> {
}
