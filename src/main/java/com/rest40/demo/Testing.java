package com.rest40.demo;

import com.rest40.demo.service.CustomerServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Testing {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RestApplication.class);
        var serv = context.getBean(CustomerServiceImpl.class);
        var obj = serv.getCustomerById(1L);
        System.out.println(obj.toString());
    }
}
