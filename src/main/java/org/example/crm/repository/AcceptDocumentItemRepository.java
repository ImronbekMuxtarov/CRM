package org.example.crm.repository;

import org.example.crm.entity.AcceptDocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptDocumentItemRepository extends JpaRepository<AcceptDocumentItem, Integer> {
}
