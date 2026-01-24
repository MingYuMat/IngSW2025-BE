package it.unife.sample.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class LoginConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }
}


//se il front end è in grado di gestire JWt allora il nostro codice diventa 
/* 
    http.csrf().disable()
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/auth/**").permitAll()  // registrazione + login liberi
        .anyRequest().authenticated()                 // tutto il resto richiede JWT
    )
    .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
 */
