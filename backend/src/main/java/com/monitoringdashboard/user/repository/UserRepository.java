package com.monitoringdashboard.user.repository;

import com.monitoringdashboard.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Recherche d'utilisateur par username pour l'authentification
    Optional<User> findByUsername(String username);

    // Vérifie si username existe déjà
    boolean existsByUsername(String username);
}
