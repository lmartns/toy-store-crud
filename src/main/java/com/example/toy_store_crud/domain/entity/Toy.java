package com.example.toy_store_crud.domain.entity;

import com.example.toy_store_crud.domain.dto.CreateToyDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "toy")
@Entity(name = "Toy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Toy {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Float price;

    public Toy(CreateToyDto createToyDto) {
        this.name = createToyDto.name();
        this.price = createToyDto.price();
    }
}
