package it.unife.sample.backend.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import it.unife.sample.backend.model.Volo;
import it.unife.sample.backend.service.VoloService;

@CrossOrigin(origins = "http://localhost:3000") // indirizzo del frontend
@RestController
@RequestMapping("/Voli")
public class VoloController {

    private final VoloService service ;

    public VoloController (VoloService service){
        this.service = service;
    }

    @GetMapping("/ricerca")
    public List<Volo> ricerca(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureStart,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureEnd,
            @RequestParam(required = false) Double maxPrice) {

        return service.ricercaVoli(from, to, departureStart, departureEnd, maxPrice);
    }
}

