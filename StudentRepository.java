package com.example.week2day4.Respository;

import com.example.week2day4.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer> {
    StudentModel findStudentModelById(Integer id);
    //Create endpoint that takes student name and return one student (return bad request if student name is invalid)
    //Create endpoint that takes student major and return all students under this major (return bad request the major)
    StudentModel findStudentModelByName(String name);

    List<StudentModel> findAllByMajor(String  major);
    //Create endpoint that takes student age and return all students who have this age or above
    List<StudentModel> findByAgeGreaterThanEqual(Integer age);


}
