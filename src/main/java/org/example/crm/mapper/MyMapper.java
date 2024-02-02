package org.example.crm.mapper;

import java.util.List;

public interface MyMapper<D, E>{
    D toDTO(E e);

    List<D> toDTOs(List<E> es);

    E toEntity(D d);
}
