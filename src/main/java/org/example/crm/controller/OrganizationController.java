package org.example.crm.controller;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.OrganizationDTO;
import org.example.crm.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService service;

    @GetMapping
    public List<OrganizationDTO> getOrganization(){
        return service.getCategories();
    }

    @GetMapping("/{id}")
    public OrganizationDTO getOrganization(@PathVariable Integer id){
        return service.getOrganization(id);
    }

    @PostMapping
    public OrganizationDTO addOrganization(@RequestBody OrganizationDTO organizationDTO){
        return service.addOrganization(organizationDTO);
    }

    @PutMapping("/{id}")
    public OrganizationDTO updateOrganization(@PathVariable Integer id, @RequestBody OrganizationDTO organizationDTO){
        return service.updateOrganization(id, organizationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Integer id){
        service.deleteOrganization(id);
    }
}
