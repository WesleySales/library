package com.project.library.controllers;

import com.project.library.dtos.LB_RentDTO;
import com.project.library.entities.LB_Rent;
import com.project.library.repositories.LB_RentRepository;
import com.project.library.services.LB_RentService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rents")
public class LB_RentController {

    @Autowired
    LB_RentService lb_rentService;

    @PostMapping
    public ResponseEntity<LB_Rent> createRent(@RequestBody LB_RentDTO data){
//        if (data.userID() == null || data.bookID() == null) {
//            return ResponseEntity.badRequest().build(); // Retorna erro se IDs estiverem nulos
//        }
        LB_Rent newRent= lb_rentService.createRent(data);
        return ResponseEntity.ok().body(newRent);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<LB_Rent> list = lb_rentService.getAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        LB_Rent lb_rent= lb_rentService.getById(id);
        return ResponseEntity.ok().body(lb_rent);
    }
}
