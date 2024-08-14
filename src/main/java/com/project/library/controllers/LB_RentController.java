package com.project.library.controllers;

import com.project.library.entities.LB_Rent;
import com.project.library.repositories.LB_RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rents")
public class LB_RentController {

    @Autowired
    LB_RentRepository lb_rentRepository;

    @GetMapping
    public ResponseEntity<List<LB_Rent>> findAll(){
        List<LB_Rent> list = lb_rentRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<LB_Rent> findById(Long id){
        LB_Rent lb_rent= lb_rentRepository.findById(id).get();
        return ResponseEntity.ok().body(lb_rent);
    }
}
