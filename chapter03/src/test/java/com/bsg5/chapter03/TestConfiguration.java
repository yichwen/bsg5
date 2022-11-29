package com.bsg5.chapter03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    MusicServiceTests musicServiceTests() {
        return new MusicServiceTests();
    }

}
