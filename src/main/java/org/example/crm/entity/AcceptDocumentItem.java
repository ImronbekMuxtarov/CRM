package org.example.crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AcceptDocumentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private AcceptDocument document;

    @ManyToOne
    private Product product;

    private Float comePrice;

    private Integer count;
}
