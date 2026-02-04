package com.monitoringdashboard.auth;

import com.monitoringdashboard.auth.dto.LoginRequest;
import com.monitoringdashboard.auth.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "API d'authentification")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @Operation(
            summary = "Connexion utilisateur",
            description = "Authentifie un utilisateur et retourne un token JWT"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Authentification réussie",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = LoginResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Identifiants invalides",
                    content = @Content
            )
    })
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}