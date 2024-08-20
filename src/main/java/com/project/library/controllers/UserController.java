package com.project.library.controllers;


import com.project.library.dtos.AuthorDTO;
import com.project.library.dtos.LB_UserDTO;
import com.project.library.entities.Author;
import com.project.library.entities.LB_User;
import com.project.library.repositories.UserRepository;
import com.project.library.services.LB_RentService;
import com.project.library.services.LB_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private LB_UserService lb_userService;

    @PostMapping
    public ResponseEntity createAuthor(@RequestBody LB_UserDTO data){
        LB_User newUser=lb_userService.createUser(data);
        return ResponseEntity.ok().body(newUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LB_User> updateUser(@PathVariable  Long id, @RequestBody LB_UserDTO data){
        LB_User newUser = lb_userService.editUser(id,data);
        return ResponseEntity.ok().body(newUser);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable  Long id){
        lb_userService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<LB_User>> findAll(){
        List<LB_User> list = lb_userService.getAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<LB_User> findById(Long id){
        LB_User user = lb_userService.getById(id);
        return ResponseEntity.ok().body(user);
    }
}
