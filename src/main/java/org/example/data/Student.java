package org.example.data;

import org.springframework.beans.factory.InitializingBean;

import java.util.Map;
import java.util.stream.Collectors;

public class Student implements InitializingBean {
    private String name;
    private Map<Subject, Integer> performance;
    private boolean transferred;

    public Student(String name, Map<Subject, Integer> performance) {
        this.name = name;
        this.performance = performance;
    }

    public Student() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        double averageGrade = performance.values().stream()
                .collect(Collectors.averagingDouble(Integer::intValue));
        transferred = averageGrade >= 3.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Subject, Integer> getPerformance() {
        return performance;
    }

    public void setPerformance(Map<Subject, Integer> performance) {
        this.performance = performance;
    }

    public boolean isTransferred() {
        return transferred;
    }

    public void setTransferred(boolean transferred) {
        this.transferred = transferred;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", performance=" + performance +
                ", transferred=" + transferred +
                '}';
    }
}
