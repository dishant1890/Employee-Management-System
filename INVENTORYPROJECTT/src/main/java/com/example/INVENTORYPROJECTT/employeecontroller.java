package com.example.INVENTORYPROJECTT;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class employeecontroller {
    @Autowired
    private employeerepo repo;
    @GetMapping("/{name}")
    public ResponseEntity<?> getbyname(@PathVariable String name){
        try {
            return ResponseEntity.ok(repo.getbyname(name));
            
        } catch (Exception e) {
            return ResponseEntity.status(404).body("failed to retirve data");
        }
    }
    @GetMapping("/Admin")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.status(200).body(repo.findAll());
    }
    @GetMapping("/department/{id}")
    public ResponseEntity<?> getbydepartt(@PathVariable int id){
        return ResponseEntity.ok(repo.getbydepart(id));
    }
    @GetMapping("/user")
        public ResponseEntity<?> getuser(){
            try{
            List<employee> de=repo.findAll();
            List<responsedto> se= new ArrayList<>();
            for(employee r:de){
                responsedto d= new responsedto();
                d.setId(r.getId());
                d.setName(r.getName());
                d.setEmail(r.getEmail());
                d.setPhone(r.getPhone());
                 d.setDesignation(r.getDesignation());
                 se.add(d);
            }
            return  ResponseEntity.ok(se);

        }
catch(Exception e){
    return ResponseEntity.status(404).body("could not find records");
}

        }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id){
        try{
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.status(404).body("could not delete");
        }
    }
    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee( @Valid @RequestBody employee emp){
        try{
            repo.save(emp);
            return ResponseEntity.status(201).body("added succesfully");
        }
        catch(Exception e){
            return ResponseEntity.status(400).body("could not add");
        }
    }
    @PutMapping("//{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id,@Valid @RequestBody employee emp){
        try{
            employee existingEmp=repo.findById(id).orElseThrow(()->new Exception("Employee not found"));
            existingEmp.setName(emp.getName());
            existingEmp.setEmail(emp.getEmail());
            existingEmp.setPhone(emp.getPhone());
            existingEmp.setSalary(emp.getSalary());
            existingEmp.setDesignation(emp.getDesignation());
            existingEmp.setJoiningdate(emp.getJoiningdate());
            repo.save(existingEmp);
            return ResponseEntity.status(200).body("updated successfully");
        }
        catch(Exception e){
            return ResponseEntity.status(400).body("could not update");
        }

    }
    @GetMapping("/Admin/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        try{
            employee emp=repo.findById(id).orElseThrow(()->new Exception("Employee not found"));
            return ResponseEntity.status(200).body(emp);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body("Employee not found");
        }
    }
     @GetMapping("/User/{id}")
    public ResponseEntity<?> userr(@PathVariable int id){
        try{
            employee emp=repo.findById(id).orElseThrow(()->new Exception("Employee not found"));
            responsedto s= new responsedto();
            s.setId(emp.getId());
            s.setName(emp.getName());
            s.setEmail(emp.getEmail());
            s.setDesignation(emp.getDesignation());
            s.setPhone(emp.getPhone());
            return ResponseEntity.status(200).body(s);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body("Employee not found");
        }
    }

    @GetMapping("/pgee")
    public ResponseEntity<?> getEmployeesByPage(@RequestParam int page,@RequestParam int size, @RequestParam String sortBy,@RequestParam String direction){
        try{
            Sort sort;
            if(direction.equalsIgnoreCase("asc")){
                sort=Sort.by(sortBy).ascending();
            }
            else{
                sort=Sort.by(sortBy).descending();
            }
            Pageable pageable=PageRequest.of(page, size, sort);
            return ResponseEntity.status(200).body(repo.findAll(pageable));

        }
        catch(Exception e){
            return ResponseEntity.status(404).body("could not fetch");
        }

        
}
}