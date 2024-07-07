package com.example.toy_store_crud.domain.product;

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

    public Toy(RequestToyDto requestToyDto) {
        this.name = requestToyDto.name();
        this.price = requestToyDto.price();
    }
}
