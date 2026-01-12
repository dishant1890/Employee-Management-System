package com.example.INVENTORYPROJECTT;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int id;
        @NotBlank
        private String name;
        @Email
        private String email;
        @Pattern(regexp= "^[0-9]{10}$")
        private String phone;
        @Positive
        private String salary;
        @NotBlank
        private String designation;
        @PastOrPresent
        private LocalDate joiningdate;
        public int getId(){
            return id;
        }
        public LocalDate getJoiningdate(){
            return joiningdate;
        }
        public void setJoiningdate(LocalDate joiningdate){
            this.joiningdate=joiningdate;
        }
        public String getDesignation(){
            return designation;
        }
        public void setDesignation(String designation){
            this.designation=designation;
        }
        public String getSalary(){
            return salary;
        }
        public void setSalary(String salary){
            this.salary=salary;
        }
        public String getPhone(){
            return phone;
        }
        public void setPhone(String phone){
            this.phone=phone;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email=email;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
        @ManyToOne
        @JoinColumn(name="department_id")
        private department department;
        
        
    
    
}
