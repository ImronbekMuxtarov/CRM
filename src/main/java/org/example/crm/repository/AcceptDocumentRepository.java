package org.example.crm.repository;

import org.example.crm.entity.AcceptDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptDocumentRepository extends JpaRepository<AcceptDocument, Integer> {
}
