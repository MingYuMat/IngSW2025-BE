package it.unife.sample.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import it.unife.sample.backend.model.Volo;
import it.unife.sample.backend.repository.VoloRepository;

@Service
public class VoloService {

    private final VoloRepository repo;

    public VoloService(VoloRepository repo) {
        this.repo = repo;
    }

    public List<Volo> ricercaVoli(String from, String to, LocalDateTime departureStart,
                                      LocalDateTime departureEnd, Double maxPrice) {
        // esempio semplice, più avanti puoi usare Specification
        List<Volo> flights = repo.findByDepartureAirportAndArrivalAirport(from, to);
        
        return flights.stream()
                .filter(f -> (departureStart == null || !f.getOraPart().isBefore(departureStart)))
                .filter(f -> (departureEnd == null || !f.getOraPart().isAfter(departureEnd)))
                .filter(f -> (maxPrice == null || f.getPrezzo() <= maxPrice))
                .toList();
    }
}
