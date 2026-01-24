package it.unife.sample.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Volo {
    @Id
    @GeneratedValue
    private Long id;

    private String partenzaAporto;
    private String arrivoAporto;
    private LocalDateTime oraPart;
    private LocalDateTime oraDest; // se andata/ritorno
    private double prezzo;
    private String airline;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getPartenzaAporto() {return partenzaAporto;}
    public void setPartenzaAporto(String partenzaAporto) {this.partenzaAporto = partenzaAporto;}

    public String getArrivoAporto() {return arrivoAporto;}
    public void setArrivoAporto(String arrivoAporto) {this.arrivoAporto = arrivoAporto;}

    public LocalDateTime getOraPart() {return oraPart;}
    public void setOraPart(LocalDateTime oraPart) {this.oraPart= oraPart;}

    public LocalDateTime getOraDest() {return oraDest;}
    public void setOraDest(LocalDateTime oraDest) {this.oraDest = oraDest;}

    public double getPrezzo() {return prezzo;}
    public void setPrice(double prezzo) {this.prezzo = prezzo;}

    public String getAirline() {return airline;}
     public void setAirline(String airline) {this.airline = airline;}
}

