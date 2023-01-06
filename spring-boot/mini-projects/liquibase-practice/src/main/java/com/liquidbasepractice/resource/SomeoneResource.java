package com.liquidbasepractice.resource;

import com.liquidbasepractice.entities.Someone;
import com.liquidbasepractice.service.SomeoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/someone")
public class SomeoneResource {

    @Autowired
    SomeoneService someoneService;

    @PostMapping
    public ResponseEntity<Someone> saveParkingSpot(@RequestBody Someone someone) {
                return ResponseEntity.status(HttpStatus.CREATED).body(someoneService.save(someone));
    }

    @GetMapping
    public ResponseEntity<List<Someone>> getAll(){
        System.out.println(someoneService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(someoneService.findAll());
    }
}
