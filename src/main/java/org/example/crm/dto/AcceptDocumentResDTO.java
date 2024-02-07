package org.example.crm.dto;

import lombok.*;
import org.example.crm.entity.Organization;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AcceptDocumentResDTO {
    private Integer id;

    private String docNumber;

    private Organization organization;

    private Date date;

    private Set<AcceptDocumentItemResDTO> items;
}
