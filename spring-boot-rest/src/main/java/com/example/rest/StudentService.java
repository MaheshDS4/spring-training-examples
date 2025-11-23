package com.example.rest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student save(Student s) {
        return repo.save(s);
    }

    public List<Student> findAll() {
        return repo.findAll();
    }

    public Student findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Student update(Integer id, Student updated) {
        Student s = repo.findById(id).orElse(null);
        if (s != null) {
            s.setName(updated.getName());
            s.setEmail(updated.getEmail());
            return repo.save(s);
        }
        return null;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
