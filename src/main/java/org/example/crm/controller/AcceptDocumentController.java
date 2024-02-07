package org.example.crm.controller;

import lombok.RequiredArgsConstructor;
import org.example.crm.dto.AcceptDocumentReqDTO;
import org.example.crm.dto.AcceptDocumentResDTO;
import org.example.crm.service.AcceptDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ad")
public class AcceptDocumentController {
    private final AcceptDocumentService service;
    @GetMapping
    public List<AcceptDocumentResDTO> getAcceptDocuments(){
        return service.getAcceptDocuments();
    }

    @GetMapping("/{id}")
    public AcceptDocumentResDTO getAcceptDocument(@PathVariable Integer id){
        return service.getAcceptDocument(id);
    }

    @PostMapping
    public AcceptDocumentResDTO addAcceptDocument(@RequestBody AcceptDocumentReqDTO reqDTO){
        return service.addAcceptDocument(reqDTO);
    }

    @PutMapping("/{id}")
    public AcceptDocumentResDTO updateAcceptDocument(@PathVariable Integer id, @RequestBody AcceptDocumentReqDTO reqDTO){
//        return service
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAcceptDocument(@PathVariable Integer id){
//        service
    }
}
