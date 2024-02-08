package org.example.config;

import org.example.data.Student;
import org.example.data.Subject;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@ComponentScan("org.example.data")
public class JavaBeanConfiguration {
    private final Random random = new Random();

    @Bean
    public Student student1() {
        Map<Subject, Integer> performance = Arrays.stream(Subject.values())
                .collect(Collectors.toMap(Function.identity(), grade -> random.nextInt(4) + 2));
        return new Student("Roy", performance);
    }

    @Bean
    public Student student2() {
        Map<Subject, Integer> performance = Arrays.stream(Subject.values())
                .collect(Collectors.toMap(Function.identity(), grade -> random.nextInt(4) + 2));
        return new Student("Jack", performance);
    }

    @Bean
    public Student student3() {
        Map<Subject, Integer> performance = Arrays.stream(Subject.values())
                .collect(Collectors.toMap(Function.identity(), grade -> 2));
        return new Student("Jil", performance);
    }

    @Bean
    public static BeanPostProcessor beanPostProcessorImpl() {
        return new BeanPostProcessorImpl();
    }
}
