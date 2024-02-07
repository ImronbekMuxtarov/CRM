package org.example.crm.dto;

import lombok.*;
import org.example.crm.entity.Product;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AcceptDocumentItemReqDTO {
    private Integer productId;

    private Float comePrice;

    private Integer count;
}
