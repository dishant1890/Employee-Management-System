package com.example.INVENTORYPROJECTT;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class insertby implements CommandLineRunner {

    private final userrepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public insertby(userrepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123")); // <-- raw password
            admin.setRole("ADMIN");
            userRepository.save(admin);
            System.out.println("Admin user created!");
        }
    }
}

