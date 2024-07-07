package com.example.toy_store_crud.controllers;

import com.example.toy_store_crud.domain.product.RequestToyDto;
import com.example.toy_store_crud.domain.product.Toy;
import com.example.toy_store_crud.domain.product.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toy")
public class ToyController {
    @Autowired
    private ToyRepository toyRepository;
    @GetMapping
    public ResponseEntity getAllToys() {
        var allToys = toyRepository.findAll();
        return ResponseEntity.ok(allToys);
    }

    @PostMapping
    public ResponseEntity createToy(@RequestBody @Validated RequestToyDto requestToyDto) {
        Toy newToy = new Toy(requestToyDto);
        toyRepository.save(newToy);
        return ResponseEntity.ok().build();
    }
}
