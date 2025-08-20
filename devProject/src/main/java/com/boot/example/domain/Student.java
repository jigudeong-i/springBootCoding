package com.boot.example.domain;


import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private int studentNumber;
    private String studentName;
    private String studentId;
    private String studentPassword;
    private int subjectNumber;
    private int studentBirth;
    private String studentPhone;
    private String studentAddress;
    private String studentEmail;
    private Date studentDate;
}
