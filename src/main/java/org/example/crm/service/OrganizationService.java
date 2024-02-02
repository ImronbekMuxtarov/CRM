package org.example.crm.service;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.OrganizationDTO;
import org.example.crm.mapper.OrganizationMapper;
import org.example.crm.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository repository;
    private final OrganizationMapper mapper;

    public List<OrganizationDTO> getCategories() {
        return mapper.toDTOs(
                repository.findAll()
        );
    }

    public OrganizationDTO getOrganization(Integer id) {
        return mapper.toDTO(
                repository.getReferenceById(id)
        );
    }

    public OrganizationDTO addOrganization(OrganizationDTO organizationDTO) {
        return mapper.toDTO(
                repository.save(
                        mapper.toEntity(organizationDTO)
                )
        );
    }

    public OrganizationDTO updateOrganization(Integer id, OrganizationDTO organizationDTO) {
        organizationDTO.setId(id);
        return mapper.toDTO(
                repository.save(
                        mapper.toEntity(organizationDTO)
                )
        );
    }

    public void deleteOrganization(Integer id){
        repository.deleteById(id);
    }
}
