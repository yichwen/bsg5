package com.bsg5.chapter09.common;

// a generic interface that defines accessors and mutators for a generic identifier
public interface BaseEntity<ID> {
    ID getId();
    void setId(ID id);
}
