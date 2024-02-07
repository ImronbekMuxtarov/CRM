package org.example.crm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AcceptDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = " varchar default 'AD_' || now() ")
    private String docNumber;

    @ManyToOne
    private Organization organization;

    @Column(columnDefinition = " date default now() ")
    private Date date;

    @OneToMany(mappedBy = "document")
    private Set<AcceptDocumentItem> items;
}
