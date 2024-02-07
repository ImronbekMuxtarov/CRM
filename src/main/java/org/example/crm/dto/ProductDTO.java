package org.example.crm.dto;

import lombok.*;
import org.example.crm.entity.Category;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {
    private Integer id;

    private String name;

    private CategoryDTO category;

    private MeasurementDTO measurement;

    private Integer amount;
}
