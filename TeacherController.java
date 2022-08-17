package com.example.week2day4.Controller;

import com.example.week2day4.Model.TeacherModel;
import com.example.week2day4.Service.TeacherService;
import com.example.week2day4.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Teachers")
@RequiredArgsConstructor
public class TeacherController {

    private  final TeacherService teacherService;

    @GetMapping("/TeacherList")
    public ResponseEntity<List> getTeachers(){
        List<TeacherModel> t = teacherService.getTeachers();
        return ResponseEntity.status(200).body(t);
    }
    @PostMapping("/TeachersList")
    public ResponseEntity<ApiResponse> addTeachers(@RequestBody @Valid TeacherModel teacherModel){
    teacherService.addTeacher(teacherModel);
        return ResponseEntity.status(200).body(new ApiResponse("New Teacher added to this " +
                "website Thnak you ",200));
    }
    @PutMapping("/TeachersList")
    public  ResponseEntity<ApiResponse> update(@RequestBody @Valid TeacherModel teacherModel , Integer id){
        teacherService.updateTeachers(teacherModel , id);
        return ResponseEntity.status(200).body(new ApiResponse("Teachers are updated", 200));

    }
    @DeleteMapping("/deleetTeachers")
    public ResponseEntity<ApiResponse> delete(Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("reacher is deleted",200));
    }
    @GetMapping("/teacherById")
    public  ResponseEntity<TeacherModel> findById(@RequestBody Integer id){
        TeacherModel teachers = teacherService.findTeacherByTeacherId(id);
        return ResponseEntity.status(200).body(teachers);
    }

    @GetMapping("/salary")
    private ResponseEntity<List> findSalary(@RequestBody Integer salary){

        List<TeacherModel> teach = teacherService.findSalaryGreaterEqual(salary);
        return ResponseEntity.status(200).body(teach);
    }
}
