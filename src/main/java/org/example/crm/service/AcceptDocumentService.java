package org.example.crm.service;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.AcceptDocumentItemResDTO;
import org.example.crm.dto.AcceptDocumentReqDTO;
import org.example.crm.dto.AcceptDocumentResDTO;
import org.example.crm.entity.AcceptDocument;
import org.example.crm.entity.AcceptDocumentItem;
import org.example.crm.mapper.AcceptDocumentItemMapper;
import org.example.crm.mapper.AcceptDocumentMapper;
import org.example.crm.repository.AcceptDocumentItemRepository;
import org.example.crm.repository.AcceptDocumentRepository;
import org.example.crm.repository.OrganizationRepository;
import org.example.crm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcceptDocumentService {
    private final AcceptDocumentRepository documentRepository;
    private final AcceptDocumentItemRepository itemRepository;
    private final AcceptDocumentMapper documentMapper;
    private final AcceptDocumentItemMapper itemMapper;
    private final OrganizationRepository organizationRepository;
    private final ProductRepository productRepository;

    public List<AcceptDocumentResDTO> getAcceptDocuments(){
        return documentMapper.toDTOs(
                documentRepository.findAll()
        );
    }

    public AcceptDocumentResDTO getAcceptDocument(Integer id){
        return documentMapper.toDTO(
                documentRepository.getReferenceById(id)
        );
    }

    public AcceptDocumentResDTO addAcceptDocument(AcceptDocumentReqDTO reqDTO){
        AcceptDocument document = createDocument(reqDTO);
        documentRepository.save(document);
        document = documentRepository.save(document);
        itemRepository.saveAll(createDocumentItems(reqDTO, document));
        return documentMapper.toDTO(document);
    }

    public AcceptDocumentResDTO updateAcceptDocument(Integer id, AcceptDocumentReqDTO reqDTO){
        AcceptDocument document = createDocument(reqDTO);
        document.setId(id);
        document = documentRepository.save(document);
        itemRepository.saveAll(createDocumentItems(reqDTO, document));
        return documentMapper.toDTO(document);
    }

    public void deleteAcceptDocument(Integer id){
        documentRepository.deleteById(id);
    }

    private AcceptDocument createDocument(AcceptDocumentReqDTO reqDTO){
        AcceptDocument document = documentMapper.toEntity(reqDTO);
        document.setOrganization(
                organizationRepository.getReferenceById(
                        reqDTO.getOrganizationId()
                )
        );
        return document;
    }

    private Set<AcceptDocumentItem> createDocumentItems(AcceptDocumentReqDTO reqDTO, AcceptDocument document){
        return reqDTO.getItems().stream()
                .map(x -> {
                    AcceptDocumentItem item = itemMapper.toEntity(x);
                    item.setProduct(
                            productRepository.getReferenceById(x.getProductId())
                    );
                    item.setDocument(document);
                    return item;
                })
                .collect(Collectors.toSet());
    }
}
