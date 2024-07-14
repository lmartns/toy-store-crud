package com.example.toy_store_crud.domain.entity;

import com.example.toy_store_crud.domain.dto.CreateToyDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "toy")
@Entity(name = "Toy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Schema(name = "Toy", description = "Toy entity")
public class Toy {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "Toy id", example = "d1fb2726-4efe-48e2-bcda-902d0500629e", required = true)
    private String id;

    @Schema(description = "Toy name", example = "Buzz", required = true)
    private String name;

    @Schema(description = "Toy price", example = "1000", required = true)
    private Float price;

    public Toy(CreateToyDto createToyDto) {
        this.name = createToyDto.name();
        this.price = createToyDto.price();
    }
}
