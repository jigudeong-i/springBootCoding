package com.boot.example.mapper;

import com.boot.example.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudentMapperTests {
    @Autowired  //자동으로 의존성 주입할 때 쓰는 어노테이션
    private StudentMapper studentMapper;

    @Test
    public void studentListTest(){
        studentMapper.studentList().stream().forEach((student -> log.info(student.toString())));
    }

}





