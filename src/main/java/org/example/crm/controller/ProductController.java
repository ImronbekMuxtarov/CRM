package org.example.crm.controller;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.ProductDTO;
import org.example.crm.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
//    private final ProductService service;
//
//    @GetMapping
//    public List<ProductDTO> getProducts(){
//        return service.getCategories();
//    }
//
//    @GetMapping("/{id}")
//    public ProductDTO getProduct(@PathVariable Integer id){
//        return service.getProduct(id);
//    }
//
//    @PostMapping
//    public ProductDTO addProduct(@RequestBody ProductDTO productDTO){
//        return service.addProduct(productDTO);
//    }
//
//    @PutMapping("/{id}")
//    public ProductDTO updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO){
//        return service.updateProduct(id, productDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable Integer id){
//        service.deleteProduct(id);
//    }
}
