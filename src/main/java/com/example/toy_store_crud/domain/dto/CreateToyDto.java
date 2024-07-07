package com.example.toy_store_crud.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateToyDto(@NotBlank String name, @NotNull Float price) {
}
