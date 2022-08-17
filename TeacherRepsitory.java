package com.example.week2day4.Respository;

import com.example.week2day4.Model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepsitory extends JpaRepository<TeacherModel,Integer> {

    TeacherModel findTeacherModelById(Integer id);
    //Create endpoint that takes teacher salary and return all teachers who have this salaray or above
    List<TeacherModel> findBySalaryGreaterThanEqual(Integer salary);
}
