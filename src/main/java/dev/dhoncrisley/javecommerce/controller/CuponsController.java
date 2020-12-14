package dev.dhoncrisley.javecommerce.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dhoncrisley.javecommerce.entity.Cupons;

import dev.dhoncrisley.javecommerce.repository.CuponsRepository;

@RestController
@RequestMapping("/cupons")
class CuponsController {

    @Autowired
    CuponsRepository repository;

    @GetMapping
    public ResponseEntity<List<Cupons>> getAll() {
        try {
            List<Cupons> items = new ArrayList<Cupons>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Cupons> getById(@PathVariable("id") String id) {
        Optional<Cupons> existingItemOptional = repository.findById(id);

        return existingItemOptional.map(cupons -> new ResponseEntity<>(cupons, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cupons> create(@RequestBody Cupons item) {
        try {
            System.out.print(item.toString());
            Cupons savedItem = repository.save(item);

            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Cupons> update(@PathVariable("id") String id, @RequestBody Cupons item) {
        Optional<Cupons> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Cupons existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}