package com.example.toy_store_crud.controllers;

import com.example.toy_store_crud.domain.dto.CreateToyDto;
import com.example.toy_store_crud.domain.entity.Toy;
import com.example.toy_store_crud.repository.ToyRepository;
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
    public ResponseEntity createToy(@RequestBody @Validated CreateToyDto createToyDto) {
        Toy newToy = new Toy(createToyDto);
        toyRepository.save(newToy);
        return ResponseEntity.ok().build();
    }
}
