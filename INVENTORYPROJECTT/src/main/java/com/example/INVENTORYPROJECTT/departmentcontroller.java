package com.example.INVENTORYPROJECTT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class departmentcontroller {
    @Autowired
    private departmentrepo repo;
    @GetMapping("/departments")
    public List<department> getdeDepartments(){
        return repo.findAll();
    }
    @PostMapping("/departments")
    public ResponseEntity<?> add(@Valid @RequestBody department dept){
        try{
            repo.save(dept);
            return ResponseEntity.status(201).body("added succesfully");
        }
        catch(Exception e){
            return ResponseEntity.status(400).body("could not add");
        }
    }
    @DeleteMapping("//{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try{
            repo.deleteById(id);
            return ResponseEntity.status(200).body("deleted successfully");
        }
        catch(Exception e){
            return ResponseEntity.status(400).body("could not delete");

}}
@PutMapping("/{id}")
public ResponseEntity<?> update(@PathVariable int id,@Valid @RequestBody department dept){
    try{
        department existingDept=repo.findById(id).orElseThrow(()->new Exception("Department not found"));
        existingDept.setName(dept.getName());
        existingDept.setDescription(dept.getDescription());
        repo.save(existingDept);
        return ResponseEntity.status(200).body("updated successfully");
    }
    catch(Exception e){
        return ResponseEntity.status(400).body("could not update");
    }

}}
