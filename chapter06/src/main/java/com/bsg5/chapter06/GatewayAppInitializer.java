package com.bsg5.chapter06;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class GatewayAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ GatewayAppWebConfig.class };
    }


    @Override
    // identifies what the root mappings will be for Spring’s DispatcherServlet to listen to
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }

}
