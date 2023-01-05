package com.kishorek.scopes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.kishorek");
        context.refresh();

        System.out.println("**** Singleton Bean ****");
        SingletonBean singletonBean1 = context.getBean("singletonBean", SingletonBean.class);
        System.out.println("Bean 1 initial value: " + singletonBean1.getValue());
        singletonBean1.setValue(100);
        System.out.println("Bean 1 changed value: " + singletonBean1.getValue());

        SingletonBean singletonBean2 = context.getBean("singletonBean", SingletonBean.class);
        System.out.println("Bean 2 initial value: " + singletonBean2.getValue());
        singletonBean2.setValue(10);
        System.out.println("Bean 2 changed value: " + singletonBean2.getValue());
        System.out.println("Bean 1 current value: " + singletonBean1.getValue());

        System.out.println("\n**** Prototype Bean ****");

        PrototypeBean prototypeBean1 = context.getBean("prototypeBean", PrototypeBean.class);
        System.out.println("Bean 1 initial value: " + prototypeBean1.getValue());
        prototypeBean1.setValue(100);
        System.out.println("Bean 1 changed value: " + prototypeBean1.getValue());

        PrototypeBean prototypeBean2 = context.getBean("prototypeBean", PrototypeBean.class);
        System.out.println("Bean 2 initial value: " + prototypeBean2.getValue());
        prototypeBean2.setValue(10);
        System.out.println("Bean 2 changed value: " + prototypeBean2.getValue());
        System.out.println("Bean 1 current value: " + prototypeBean1.getValue());
    }
}