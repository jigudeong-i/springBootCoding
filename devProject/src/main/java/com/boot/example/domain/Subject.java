package com.boot.example.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Subject {
    private int no;
    private String subjectNumber;
    private String subjectName;
}
