package com.bsg5.chapter09.common;

// an interface that defines access to a name field for an artist and extends BaseEntity
public interface BaseArtist<ID> extends BaseEntity<ID> {
    // get artist name
    String getName();
    void setName(String name);
}
