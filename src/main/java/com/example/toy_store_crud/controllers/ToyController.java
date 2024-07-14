package com.example.toy_store_crud.controllers;

import com.example.toy_store_crud.domain.dto.CreateToyDto;
import com.example.toy_store_crud.domain.dto.DeleteToyDto;
import com.example.toy_store_crud.domain.dto.UpdateToyDto;
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

    @GetMapping("/{id}")
    public ResponseEntity getToy(@PathVariable String id) {
        var toy = toyRepository.findById(id);
        if(toy.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toy.get());
    }

    @GetMapping
    public ResponseEntity getAllToys() {
        var allToys = toyRepository.findAll();
        return ResponseEntity.ok(allToys);
    }

    @PostMapping
    public ResponseEntity createToy(@RequestBody @Validated CreateToyDto createToyDto) {
        Toy newToy = new Toy(createToyDto);
        toyRepository.save(newToy);
        return ResponseEntity.ok(newToy);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateToy(@PathVariable String id, @RequestBody UpdateToyDto updateToyDto) {
        var toy = toyRepository.findById(id);
        if (toy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Toy toyToUpdate = toy.get();
        toyToUpdate.setName(updateToyDto.name());
        toyToUpdate.setPrice(updateToyDto.price());
        toyRepository.save(toyToUpdate);
        return ResponseEntity.ok(toyToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteToy(@PathVariable String id, DeleteToyDto deleteToyDto) {
        var toy = toyRepository.findById(deleteToyDto.id());
        if (toy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        toyRepository.delete(toy.get());
        return ResponseEntity.ok().build();
    }

}
