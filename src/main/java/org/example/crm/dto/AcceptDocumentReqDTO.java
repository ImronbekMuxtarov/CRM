package org.example.crm.dto;

import lombok.*;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AcceptDocumentReqDTO {
    private Integer organizationId;

    private Date date;

    private Set<AcceptDocumentItemReqDTO> items;
}
