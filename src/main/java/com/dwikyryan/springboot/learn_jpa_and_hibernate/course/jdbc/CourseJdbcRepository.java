package com.dwikyryan.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dwikyryan.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {
    private JdbcTemplate springJdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.springJdbcTemplate = jdbcTemplate;
    }

    private static String INSERT_QUERY = """
            INSERT INTO COURSE (id, name, author)
            VALUES(?, ?, ?)
            """;

    private static String DELETE_QUERY = """
            DELETE FROM COURSE WHERE ID = ?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
}
