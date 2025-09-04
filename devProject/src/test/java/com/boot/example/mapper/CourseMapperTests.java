package com.boot.example.mapper;

import com.boot.example.domain.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CourseMapperTests {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void boardListTest() {
        Course course = null;
        courseMapper.courseList().stream().forEach(courseData -> log.info(courseData.toString()));
    }

}
