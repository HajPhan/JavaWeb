package com.example.springbootbean;

import com.example.springbootbean.consumer.MyApplication;
import com.example.springbootbean.service.MessageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.example.springbootbean.consumer"})
public class MyApplicationTest {

    private AnnotationConfigApplicationContext context = null;

    @Bean
    public MessageService getService(){
        return new MessageService() {
            @Override
            public boolean sendMessage(String msg, String rec) {
                System.err.println("Mock Service");
                return true;
            }
        };
    }

    @Before
    public void setUp(){
        context = new AnnotationConfigApplicationContext(MyApplicationTest.class);
    }

    @After
    public void tearDown(){
        context.close();
    }

    @Test
    public void test(){
        MyApplication app = context.getBean(MyApplication.class);
        Assert.assertTrue(app.processMessage("Hi Hai","hai@gmail.com"));
    }
}
