package org.example.crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Float price;

    private String unit;

    private Integer amount;

    @ManyToOne
    private Category category;
}
