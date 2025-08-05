package com.example.demo.vo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
@Data
@Slf4j

public class Member {
    private Long id;
    private String name;
    private String email;
    private int age;

    Member member = Member.builder().id(1002L).name("홍길동").build();



}
