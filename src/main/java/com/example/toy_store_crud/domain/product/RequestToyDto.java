package com.example.toy_store_crud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestToyDto(@NotBlank String name, @NotNull Float price) {
}
