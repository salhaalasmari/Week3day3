package com.example.week2day4.Service;

import com.example.week2day4.Exception.ApiException;
import com.example.week2day4.Model.TeacherModel;
import com.example.week2day4.Respository.TeacherRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepsitory teacherRepsitory;

    public List<TeacherModel> findSalaryGreaterEqual(Integer salary){
     List<TeacherModel> t3=   teacherRepsitory.findBySalaryGreaterThanEqual(salary);
     if(t3.isEmpty()){
         throw  new ApiException("no teacher by this salary equal  or grater tha");
     }
        return t3;
    }

    public TeacherModel findTeacherByTeacherId(Integer id){
 TeacherModel t2 =teacherRepsitory.findTeacherModelById(id);
 if(t2==null){

     throw new ApiException(" bad request because teacher id is invalid");
 }
return t2;
    }

    public List<TeacherModel> getTeachers(){
        return teacherRepsitory.findAll();
    }
    public void addTeacher(TeacherModel teacherModel){
        teacherRepsitory.save(teacherModel);
    }
    public void updateTeachers( TeacherModel teacherModel , Integer id ){
        TeacherModel t = teacherRepsitory.getById(id);
       // t.setId(teacherModel.getId());
        if(t==null){
            throw new ApiException("Wrong in teacher ID!");
        }
        t.setName(teacherModel.getName());
        t.setSalary(teacherModel.getSalary());
        teacherRepsitory.save(t);
    }
    public void deleteTeacher(Integer id){
        TeacherModel delete= teacherRepsitory.getById(id);
        if(delete==null){
            throw new ApiException("Wrong in teacher ID!");
        }
        teacherRepsitory.delete(delete);
    }
}
