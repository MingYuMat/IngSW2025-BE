package it.unife.sample.backend.controller;


import it.unife.sample.backend.dto.*;
import it.unife.sample.backend.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000") // indirizzo del frontend
@RestController
@RequestMapping("/api/auth")
public class RegisController {

    private final Registrazione authService;

    public RegisController(Registrazione authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("Utente registrato con successo");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    String token = authService.login(request);  // 
    return ResponseEntity.ok(new LoginResponse(token));
}

}