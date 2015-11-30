package com.devs.issuetracker.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wamalalawrence on 15/11/21.
 * This class allows access to Spring beans in Unit tests.
 */
public class TestApplicationContext
{
    private static TestApplicationContext testContext = null;
    ApplicationContext context = null;

    public TestApplicationContext() {
    }

    public static TestApplicationContext getInstance()
    {
        if (testContext == null) {
            testContext = new TestApplicationContext();
            testContext.initialise();
        }
        return testContext;
    }

    public void initialise() {
        context = new ClassPathXmlApplicationContext(
                new String[]{"dispatcher-servlet.xml"});
    }

    public Object getBean(String name) {
        return context.getBean(name);
    }

    public ApplicationContext getSpringContext() {
        return context;
    }

}
