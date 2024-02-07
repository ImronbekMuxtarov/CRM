package org.example.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AcceptDocumentItemResDTO {
    private Integer id;

    private Integer documentId;

    private ProductDTO product;

    private Float comePrice;

    private Integer count;
}
