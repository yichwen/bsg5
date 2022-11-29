package com.bsg5.chapter02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.assertEquals;

public class SpringGreeterTest {

    @Test
    public void testHelloWorld() {
        // in the xml configuration file
        // create a ByteArrayOutputStream bean
        // create a PrintStream by injecting ByteArrayOutputStream
        // create a HelloWorldGreeter bean by injecting PrintStream
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Greeter greeter = context.getBean("helloGreeter", Greeter.class);
        ByteArrayOutputStream baos = context.getBean("baos", ByteArrayOutputStream.class);
        // will write a string to the PrintStream (ByteArrayOutputStream)
        greeter.greet();
        // get ByteArrayOutputStream
        String data = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        // check the string being written is "Hello, World!"
        assertEquals(data, "Hello, World!");
    }

}
