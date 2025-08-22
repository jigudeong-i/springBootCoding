package com.boot.example.mapper;

import com.boot.example.domain.Subject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SubjectMapperTests {
    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    public void subjectListTest() {
        subjectMapper.subjectList().stream().forEach(subject -> log.info(subject.toString()));

    }
}