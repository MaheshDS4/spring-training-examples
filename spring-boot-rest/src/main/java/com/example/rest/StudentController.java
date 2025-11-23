package com.example.rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student s) {
        return service.save(s);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
