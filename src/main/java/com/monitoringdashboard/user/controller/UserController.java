package com.monitoringdashboard.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "Gestion des utilisateurs")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    @GetMapping("/profile")
    @Operation(
            summary = "Obtenir le profil de l'utilisateur connecté",
            description = "Retourne les informations de l'utilisateur authentifié"
    )
    public ResponseEntity<String> getProfile(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok("Profile de: " + username);
    }

    @GetMapping("/admin")
    @Operation(
            summary = "Route admin uniquement",
            description = "Route accessible uniquement aux administrateurs"
    )
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Vous êtes admin !");
    }
}