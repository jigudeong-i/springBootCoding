package com.boot.example.domain;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    private int no;
    private String subjectNumber;
    private String subjectName;


}
