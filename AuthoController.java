package com.example.week2day4.Controller;

import com.example.week2day4.Model.user;
import com.example.week2day4.Service.AuthService;
import com.example.week2day4.dto.ApiResponse;
import com.example.week2day4.dto.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.ArrayType;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthoController {
    private  final AuthService authService;

    @GetMapping("/usersList")
    public ResponseEntity<List> getUsers(){
        List<user> users = authService.getUsers();
        return  ResponseEntity.status(200).body(users);
    }
    @PostMapping("/usersList")
    public ResponseEntity<ApiResponse> addUser(@RequestBody @Valid user u){
        authService.addUsers(u);
        return  ResponseEntity.status(200).body(new ApiResponse("new user added",200));
    }
    @PutMapping("/usersList/{id}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody @Valid user u , @PathVariable Integer id){
        authService.updateUser(u , id);
        return  ResponseEntity.status(200).body(new ApiResponse("new user updated",200));
    }
    @DeleteMapping("/usersList/{id}")
    public ResponseEntity<ApiResponse> DeleteUser( @PathVariable Integer id){
        authService.deleteUser(id);
        return  ResponseEntity.status(200).body(new ApiResponse("new user deleted",200));
    }
    @GetMapping("/usersList/name")
    public ResponseEntity<user> getUsersbyname(@RequestParam String username){
        user n = authService.getUserByName(username);
        return  ResponseEntity.status(200).body(n);
    }
    @GetMapping("/usersList/grade")
    public ResponseEntity<List<user>> getUsersbygrade(@RequestParam Integer grade){
     List<user>  n = authService.findgrade(grade);
        return  ResponseEntity.status(200).body(n);
    }
    @GetMapping("/usersList/findByUsernameAndId")
    public ResponseEntity<user> getUsersbyusernameAndId(@RequestParam Integer id , @RequestParam String username){
        user  n = authService.findbyUsernameAndId(username ,id);
        return  ResponseEntity.status(200).body(n);
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginForm loginForm){
        authService.login(loginForm);
        return  ResponseEntity.status(200).body(new ApiResponse("log in successfully",200));
    }
}
