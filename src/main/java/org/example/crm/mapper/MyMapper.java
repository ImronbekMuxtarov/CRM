package org.example.crm.mapper;

import java.util.List;

public interface MyMapper<RQ, RS, E>{
    RS toDTO(E e);

    List<RS> toDTOs(List<E> es);

    E toEntity(RQ d);
}
