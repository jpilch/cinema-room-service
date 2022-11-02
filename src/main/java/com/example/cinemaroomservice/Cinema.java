package com.example.cinemaroomservice;

import java.util.List;

public class Cinema {
    private final Seats seats;
    public Cinema() {
        this.seats = new Seats();
    }
    public List<Seat> getAvailableSeats() {
        return this.seats.getAvailableSeats();
    }
}
