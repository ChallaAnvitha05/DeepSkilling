package com.library;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/**
 * Test class for Library Management Application
 */
public class LibraryManagementApplicationTest {
    
    private ApplicationContext context;
    
    @Before
    public void setUp() {
        // Load Spring context before each test
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @After
    public void tearDown() {
        // Close context after each test
        if (context instanceof ClassPathXmlApplicationContext) {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
    
    @Test
    public void testSpringContextLoads() {
        // Test that Spring context loads successfully
        assertNotNull("Spring context should not be null", context);
        System.out.println("Spring context loaded successfully in test");
    }
    
    @Test
    public void testApplicationContextContainsBeans() {
        // Test that context contains expected beans
        String[] beanNames = context.getBeanDefinitionNames();
        assertTrue("Context should contain beans", beanNames.length > 0);
        
        // Print all bean names for debugging
        System.out.println("Beans in context:");
        for (String beanName : beanNames) {
            System.out.println("- " + beanName);
        }
    }
}
