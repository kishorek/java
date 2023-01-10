package com.kishorek;


import com.kishorek.mappers.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringMain {
    @Autowired
    private AddressMapper mapper;

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.kishorek");
        context.refresh();

        SpringMain springMain = context.getBean("springMain", SpringMain.class);
        Map addressMap = Map.of("addrLine1","10 Downing Street");
        System.out.println(springMain.mapper.addressFromMap(addressMap));
    }
}
