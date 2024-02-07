package org.example.crm.mapper;

import org.example.crm.dto.AcceptDocumentReqDTO;
import org.example.crm.dto.AcceptDocumentResDTO;
import org.example.crm.entity.AcceptDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcceptDocumentMapper extends MyMapper<AcceptDocumentReqDTO, AcceptDocumentResDTO, AcceptDocument>{
}
