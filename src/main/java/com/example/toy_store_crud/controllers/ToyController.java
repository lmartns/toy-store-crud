package com.example.toy_store_crud.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toy")
public class ToyController {
    @GetMapping
    public ResponseEntity getAllToys() {
        return ResponseEntity.ok("Deu certo");
    }
}
