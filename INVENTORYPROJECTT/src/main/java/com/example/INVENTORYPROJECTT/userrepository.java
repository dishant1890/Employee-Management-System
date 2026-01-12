package com.example.INVENTORYPROJECTT;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userrepository  extends JpaRepository<AppUser, Integer> {
    java.util.Optional<AppUser> findByUsername(String username);
    
}
