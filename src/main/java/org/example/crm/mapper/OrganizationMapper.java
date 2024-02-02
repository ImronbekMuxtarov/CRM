package org.example.crm.mapper;

import org.example.crm.dto.OrganizationDTO;
import org.example.crm.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends MyMapper<OrganizationDTO, Organization>{
}
