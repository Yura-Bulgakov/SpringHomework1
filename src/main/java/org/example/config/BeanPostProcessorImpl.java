package org.example.config;

import org.example.data.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            Student student = (Student) bean;
            if (student.getName().equals("Jil")) {
                student.getPerformance().replaceAll((subject, grade) -> grade < 3 ? 3 : grade);
            }
        }
        return bean;
    }
}
