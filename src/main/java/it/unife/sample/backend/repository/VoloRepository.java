package it.unife.sample.backend.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import it.unife.sample.backend.model.Volo;

public interface VoloRepository extends JpaRepository<Volo, Long> {
    
    List<Volo> findByDepartureAirportAndArrivalAirport(String partenza, String arrivo);

    List<Volo> findByPriceLessThanEqual(double maxPrice);

    // Query custom con data
    List<Volo> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);
}

