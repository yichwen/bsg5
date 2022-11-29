package com.bsg5.chapter03;

public interface Normalizer {
    default String transform(String input) {
        return input.trim();
    }
}
