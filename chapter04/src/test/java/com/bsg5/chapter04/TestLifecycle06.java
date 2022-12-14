package com.bsg5.chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.testng.Assert.*;

@Component
class SeventhObject extends HasData {

    static Object semaphore = null;

    @PostConstruct
    public void initialize() throws Exception {
        semaphore = new Object();
    }

    @PreDestroy
    public void dispose() throws Exception {
        semaphore = null;
    }
}

// use new annotated.xml due to context close...
@ContextConfiguration(locations = "/annotated-06.xml")
public class TestLifecycle06 extends AbstractTestNGSpringContextTests {

    @Autowired
    ConfigurableApplicationContext context;

    @Test
    public void testInitDestroyMethods() {
        SeventhObject o1 = context.getBean(SeventhObject.class);
        assertNotNull(SeventhObject.semaphore);
        assertEquals(o1.getDatum(), "default");
        context.close();
        assertNull(SeventhObject.semaphore);
    }

}
