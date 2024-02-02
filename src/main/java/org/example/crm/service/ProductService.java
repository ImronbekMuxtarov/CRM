package org.example.crm.service;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.ProductDTO;
import org.example.crm.mapper.ProductMapper;
import org.example.crm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductDTO> getCategories() {
        return mapper.toDTOs(
                repository.findAll()
        );
    }

    public ProductDTO getProduct(Integer id) {
        return mapper.toDTO(
                repository.getReferenceById(id)
        );
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        return mapper.toDTO(
                repository.save(
                        mapper.toEntity(productDTO)
                )
        );
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        productDTO.setId(id);
        return mapper.toDTO(
                repository.save(
                        mapper.toEntity(productDTO)
                )
        );
    }

    public void deleteProduct(Integer id){
        repository.deleteById(id);
    }
}
