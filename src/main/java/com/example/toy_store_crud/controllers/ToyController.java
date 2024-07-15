package com.example.toy_store_crud.controllers;

import com.example.toy_store_crud.domain.dto.CreateToyDto;
import com.example.toy_store_crud.domain.dto.DeleteToyDto;
import com.example.toy_store_crud.domain.dto.UpdateToyDto;
import com.example.toy_store_crud.domain.entity.Toy;
import com.example.toy_store_crud.repository.ToyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toy")
public class ToyController {
    @Autowired
    private ToyRepository toyRepository;

    @Operation(summary = "Get a toy by id")
    @ApiResponse(responseCode = "200", description = "Found the toy")
    @ApiResponse(responseCode = "404", description = "Toy not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/{id}")
    public ResponseEntity getToy(@PathVariable String id) {
        var toy = toyRepository.findById(id);
        if(toy.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toy.get());
    }

    @Operation(summary = "Get all toys")
    @ApiResponse(responseCode = "200", description = "Found all toys")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @ApiResponse(responseCode = "404", description = "Toys not found")
    @GetMapping
    public ResponseEntity getAllToys() {
        var allToys = toyRepository.findAll();
        return ResponseEntity.ok(allToys);
    }

    @Operation(summary = "Create a toy")
    @ApiResponse(responseCode = "201", description = "Toy created")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @PostMapping
    public ResponseEntity createToy(@RequestBody @Validated CreateToyDto createToyDto) {
        Toy newToy = new Toy(createToyDto);
        toyRepository.save(newToy);
        return new ResponseEntity<>(newToy, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a toy")
    @ApiResponse(responseCode = "200", description = "Toy updated")
    @ApiResponse(responseCode = "404", description = "Toy not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
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

    @Operation(summary = "Delete a toy")
    @ApiResponse(responseCode = "200", description = "Toy deleted")
    @ApiResponse(responseCode = "404", description = "Toy not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
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
