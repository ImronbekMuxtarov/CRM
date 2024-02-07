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

    @ManyToOne
    private Category category;

    @ManyToOne
    private Measurement measurement;

    private Integer amount;
}
