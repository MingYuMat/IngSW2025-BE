package it.unife.sample.backend.service;

import it.unife.sample.backend.dto.LoginRequest;
import it.unife.sample.backend.dto.RegisterRequest;
import it.unife.sample.backend.model.Utente;
import it.unife.sample.backend.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;


@Service //AuthService
public class Registrazione {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String SECRET_STRING = "supercalifragilistichespiralitoso";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes()); //conversione della mia stringa segreta in Key 
    
    public Registrazione(UtenteRepository utenteRepository,
                       PasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {

        if (utenteRepository.existsByNickname(request.getNickname())) {
            throw new RuntimeException("Nickname già in uso");
        }

        Utente user = new Utente();
        user.setNickname(request.getNickname());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        utenteRepository.save(user);
    }

    public String login(LoginRequest request) {
        Utente user = utenteRepository.findByNickname(request.getNickname())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Password errata");
        }

        // Genera JWT
        return Jwts.builder()
                .setSubject(user.getNickname())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 giorno
                .signWith(SECRET_KEY,SignatureAlgorithm.HS256)
                .compact();
    }

}
