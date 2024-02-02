package org.example.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrganizationDTO {
    private Integer id;

    private String name;

    private String address;

    private String number;

    private String description;
}
