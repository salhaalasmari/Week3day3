package com.example.week2day4.Controller;

import com.example.week2day4.Model.StudentModel;
import com.example.week2day4.Model.TeacherModel;
import com.example.week2day4.Service.StudentService;
import com.example.week2day4.dto.ApiResponse;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Students")
@RequiredArgsConstructor
public class StudentsController {

    private  final StudentService studentService;
    @GetMapping("/StudentsList")
    public ResponseEntity<List> getStudnts(){
        List<StudentModel> s = studentService.getStudents();
        return ResponseEntity.status(200).body(s);
    }
    @PostMapping("/StudentsList")
    public ResponseEntity<ApiResponse> addStudents(StudentModel studentModel){
        studentService.addStudents(studentModel);
        return ResponseEntity.status(200).body(new ApiResponse("new students added",200));

    }
    @PutMapping("/StudentsList")
    public  ResponseEntity<ApiResponse> update(@RequestBody @Valid StudentModel studentModel , Integer id){
      studentService.update(studentModel , id);
        return ResponseEntity.status(200).body(new ApiResponse("students are updated", 200));

    }

    @DeleteMapping("/StudentsList")
    public ResponseEntity<ApiResponse> delete(Integer id){
        studentService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("students is deleted",200));
    }

    @GetMapping("/byStudentId")
    public ResponseEntity<StudentModel> findId( Integer id){
        StudentModel st1 = studentService.findStudentBtId(id);
        return ResponseEntity.status(200).body(st1);

    }
    @GetMapping("/byStudentName")
    public ResponseEntity<StudentModel> findName(String name){
        StudentModel st2 = studentService.findStudentByname(name);
        return ResponseEntity.status(200).body(st2);

    }

    @GetMapping("/byStudentAge")
    public  ResponseEntity<List> findAge(Integer age){
        List<StudentModel> st4 = studentService.findAge(age);
        return ResponseEntity.status(200).body(st4);

    }
    @GetMapping("/byStudentMajor")
    public  ResponseEntity<List> findMajor(String major){

        List<StudentModel> st5 = studentService.findAllByMajor(major);
        return ResponseEntity.status(200).body(st5);
    }
}
