package com.example.toy_store_crud.domain.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateToyDto (@NotNull String id,
                            String name,
                            Float price){
}
