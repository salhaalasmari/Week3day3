package com.example.week2day4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class StudentModel {
    // ID , name , age , major ( all should not be empty ) ( major enum { CS , MATH , Engineer )
    @Id
   @NotNull(message = "id must not be null")
    private Integer id ;
    @NotEmpty(message = "student name must nor be empty")
    private  String name;
    @NotEmpty(message = "major must not be empty")
    @Column(columnDefinition = "varchar(20) check (major='CS' or major='MATH' or major='Engineer')")
    private String major;
    @NotNull(message = "age must not be null")
    private Integer age ;
}
