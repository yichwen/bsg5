package com.bsg5.chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.*;

class SecondObject extends HasData {
    SecondObject(String initialValue) {
        setDatum(initialValue);
    }
}

@ContextConfiguration(locations = "/config-02.xml")
public class TestLifecycle02 extends AbstractTestNGSpringContextTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void validateConstruction() {
        HasData o1 = context.getBean(HasData.class);
        assertEquals(o1.getDatum(), "Initial Value");
    }

}
