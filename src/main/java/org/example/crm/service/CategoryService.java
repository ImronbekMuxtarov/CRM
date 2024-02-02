package org.example.crm.service;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.CategoryDTO;
import org.example.crm.mapper.CategoryMapper;
import org.example.crm.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public List<CategoryDTO> getCategories(){
        return mapper.toDTOs(
                repository.findAll()
        );
    }

    public CategoryDTO getCategory(Integer id){
        return mapper.toDTO(
                repository.getReferenceById(id)
        );
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO){
        return mapper.toDTO(
                repository.save(
                        mapper.toEntity(categoryDTO)
                )
        );
    }

    public CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO){
        categoryDTO.setId(id);
        return mapper.toDTO(
                repository.save(
                        mapper.toEntity(categoryDTO)
                )
        );
    }

    public void deleteCategory(Integer id){
        repository.deleteById(id);
    }
}
