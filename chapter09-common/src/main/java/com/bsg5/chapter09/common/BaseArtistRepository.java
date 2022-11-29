package com.bsg5.chapter09.common;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BaseArtistRepository<T extends BaseArtist<ID>, ID> extends CrudRepository<T, ID> {
    List<T> findAllByNameIsLikeIgnoreCaseOrderByName(String name);
    Optional<T> findByNameIgnoreCase(String name);
}
