package com.dwikyryan.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dwikyryan.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private CourseJdbcRepository repository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {
        this.repository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Now!", "Max Schwarzmuller"));
        repository.insert(new Course(2, "Learn GCP Now!", "Max Schwarzmuller"));
        repository.insert(new Course(3, "Learn DevOps Now!", "Max Schwarzmuller"));

        repository.deleteById(1);
        repository.deleteById(3);
    }

}
