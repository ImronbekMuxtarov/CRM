package org.example.crm.service;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.AcceptDocumentItemReqDTO;
import org.example.crm.dto.AcceptDocumentItemResDTO;
import org.example.crm.dto.AcceptDocumentResDTO;
import org.example.crm.entity.AcceptDocumentItem;
import org.example.crm.mapper.AcceptDocumentItemMapper;
import org.example.crm.repository.AcceptDocumentItemRepository;
import org.example.crm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcceptDocumentItemService {
    private final AcceptDocumentItemRepository itemRepository;
    private final AcceptDocumentItemMapper itemMapper;
    private final ProductRepository productRepository;

    public List<AcceptDocumentItemResDTO> getAcceptDocumentItems(){
        return itemMapper.toDTOs(
                itemRepository.findAll()
        );
    }

    public AcceptDocumentItemResDTO getAcceptDocumentItem(Integer id){
        return itemMapper.toDTO(
                itemRepository.getReferenceById(id)
        );
    }

    public AcceptDocumentItemResDTO addAcceptDocumentItem(AcceptDocumentItemReqDTO reqDTO){
        AcceptDocumentItem item = itemMapper.toEntity(reqDTO);
        item.setProduct(
                productRepository.getReferenceById(
                        reqDTO.getProductId()
                )
        );
        return null;
    }
}
