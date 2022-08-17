package com.example.week2day4.Service;

import com.example.week2day4.Exception.ApiException;
import com.example.week2day4.Model.StudentModel;
import com.example.week2day4.Respository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public List<StudentModel> findAllByMajor(String major){
        List<StudentModel> s4 = studentRepository.findAllByMajor(major);
        if(s4==null){
            throw  new ApiException("There is no students same as ur this major!");
        }
        return s4;

    }
 public List<StudentModel> findAge(Integer age){
        List<StudentModel> s4 =studentRepository.findByAgeGreaterThanEqual(age);
        if(s4==null){
            throw new ApiException("There is no students same  this age or grater than!");
        }
        return  s4;
 }
    public StudentModel findStudentByname(String name){
        StudentModel s2 = studentRepository.findStudentModelByName(name);
        if(s2==null){
            throw new ApiException(("error in student id"));
        }
        return  s2;
    }

    public StudentModel findStudentBtId(Integer id){

        StudentModel s2 = studentRepository.findStudentModelById(id);
        if(s2==null){
            throw new ApiException(" bad request because student id is invalid");
        }
        return s2;
    }

    public List<StudentModel> getStudents(){
        return studentRepository.findAll();
    }
    public void addStudents(StudentModel studentModel){
        studentRepository.save(studentModel);
    //    studentRepository.save(studentModel);

    }
    public void update(StudentModel studentModel , Integer id){
        StudentModel oldStudents = studentRepository.getById(id);
        if(oldStudents==null){
            throw new ApiException("Wrong in student ID!");
        }
        oldStudents.setName(studentModel.getName());
        oldStudents.setMajor(studentModel.getMajor());
        studentRepository.save(oldStudents);

    }
    public void delete(Integer id){
        StudentModel s = studentRepository.getById(id);
        if(s==null){
            throw new ApiException("Wrong in student ID!");
        }
        studentRepository.delete(s);
    }
}
