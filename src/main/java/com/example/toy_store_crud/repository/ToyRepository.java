package com.example.toy_store_crud.repository;

import com.example.toy_store_crud.domain.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, String> {
}
