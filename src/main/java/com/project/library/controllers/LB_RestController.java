package com.project.library.controllers;



import com.project.library.entities.LB_Rest;
import com.project.library.repositories.LB_RestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rests")
public class LB_RestController {

    @Autowired
    LB_RestRepository lb_restRepository;

    @GetMapping
    public ResponseEntity<List<LB_Rest>> findAll(){
        List<LB_Rest> list = lb_restRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<LB_Rest> findById(Long id){
        LB_Rest lb_rest= lb_restRepository.findById(id).get();
        return ResponseEntity.ok().body(lb_rest);
    }
}
