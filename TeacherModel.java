package com.example.week2day4.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class TeacherModel {
    //Teacher Class : ID , name , salary ( all should not be empty)
    @Id
    @NotNull(message = "Teacher id must not be empty")
    private Integer id;
    @NotEmpty(message = "Teacher name must not be empty")
    private  String name;
    @NotNull(message = "salary must not be empty")
    private  Integer salary;
}
