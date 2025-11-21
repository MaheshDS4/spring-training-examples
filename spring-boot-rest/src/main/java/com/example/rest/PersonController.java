package com.example.rest;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final Map<Integer, Person> store = new HashMap<>();
    private final AtomicInteger idGen = new AtomicInteger(1);

    @GetMapping
    public Collection<Person> all() {
        return store.values();
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable int id) {
        return store.get(id);
    }

    @PostMapping
    public Person create(@RequestBody Person p) {
        int id = idGen.getAndIncrement();
        p.setId(id);
        store.put(id, p);
        return p;
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable int id, @RequestBody Person p) {
        p.setId(id);
        store.put(id, p);
        return p;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        store.remove(id);
    }
}
