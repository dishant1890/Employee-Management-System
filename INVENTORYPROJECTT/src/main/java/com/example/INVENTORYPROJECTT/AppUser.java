package com.example.INVENTORYPROJECTT;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String role;
    public int GetId(){
        return id;
    }
    public String GetUsername(){
        return username;
    }
    public void SetUsername(String username){
        this.username=username;
    }
    public String GetPassword(){
        return password;
    }
    public void SetPassword(String password){
        this.password=password;
    }
    public String GetRole(){
        return role;
    }
    public void SetRole(String role){
        this.role=role;
    }

    
}