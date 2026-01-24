package it.unife.sample.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.unife.sample.backend.model.*;


    @Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Optional<Utente> findByNickname(String nickname);

    boolean existsByNickname(String nickname);
}


//import JpaRepository mi permette di fare operazioni CRUD senza codice SQL , richiede 2 par (entity da gestire e tipo di chiave primaria)
// @repository dice a spring che questa interfaccia è responsabile per l'accesso ai dati 