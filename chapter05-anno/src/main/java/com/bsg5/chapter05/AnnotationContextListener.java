package com.bsg5.chapter05;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AnnotationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ApplicationContext context = buildAnnotationContext();
        event.getServletContext().setAttribute("context", context);
    }

    private ApplicationContext buildAnnotationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // simply telling the context where it should scan doesn’t make it actually perform the scan
        context.scan("com.bsg5.chapter03.mem03");
        // that's the role of context.refresh()
        context.refresh();
        return context;
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
