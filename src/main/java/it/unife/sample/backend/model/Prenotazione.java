package it.unife.sample.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Prenotazione {
    @Id 
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Utente user;

    @ManyToOne
    private Volo flight;
    private int seats;
    private LocalDateTime bookingTime;
    
    public LocalDateTime getBookingTime() {return bookingTime;}
    public void setBookingTime(LocalDateTime bookingTime) {this.bookingTime = bookingTime;}

    public int getSeats() {return seats;}
    public void setSeats(int seats) {this.seats = seats;}
}
