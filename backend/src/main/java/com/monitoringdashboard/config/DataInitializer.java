package com.monitoringdashboard.config;

import com.monitoringdashboard.user.model.User;
import com.monitoringdashboard.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));

            userRepository.save(admin);
            System.out.println("✅ Compte admin créé avec succès !");
            System.out.println("   Username: admin");
            System.out.println("   Password: admin123");
        }

        if (!userRepository.existsByUsername("user")) {
            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user123"));


            userRepository.save(user);
            System.out.println("✅ Compte utilisateur créé avec succès !");
            System.out.println("   Username: user");
            System.out.println("   Password: user123");
        }
    }
}