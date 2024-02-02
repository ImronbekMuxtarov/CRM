package org.example.crm.controller;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.CategoryDTO;
import org.example.crm.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public List<CategoryDTO> getCategories(){
        return service.getCategories();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategory(@PathVariable Integer id){
        return service.getCategory(id);
    }

    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO){
        return service.addCategory(categoryDTO);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO){
        return service.updateCategory(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id){
        service.deleteCategory(id);
    }
}
