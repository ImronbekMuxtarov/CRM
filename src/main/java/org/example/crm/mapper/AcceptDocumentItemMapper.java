package org.example.crm.mapper;

import org.example.crm.dto.AcceptDocumentItemReqDTO;
import org.example.crm.dto.AcceptDocumentItemResDTO;
import org.example.crm.entity.AcceptDocumentItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcceptDocumentItemMapper extends MyMapper<AcceptDocumentItemReqDTO, AcceptDocumentItemResDTO, AcceptDocumentItem>{
}
