package com.example.java_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo.model.Employee;

@RestController
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return ResponseEntity.ok().body("added successfully");
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        for (Employee e : employees) {
            if (e.getId() == Integer.parseInt(id)) {
                return ResponseEntity.ok().body(e);
            }
        }
        return ResponseEntity.ok().body("employee not found");
    }

    @GetMapping("/find")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(employees);
    }
}
