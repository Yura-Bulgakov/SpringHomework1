package org.example;

import org.example.config.JavaBeanConfiguration;
import org.example.data.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("app_context.xml");
        Teacher teacher1 = xmlContext.getBean("teacher", Teacher.class);
        System.out.println(teacher1);
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(JavaBeanConfiguration.class);
        Teacher teacher2 = annotationContext.getBean("teacher", Teacher.class);
        System.out.println(teacher2);
    }
}