package com.example.cinemaroomservice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Seats {
    private final List<List<Seat>> seats;
    private final HashMap<Seat, Boolean> seatState;

    public Seats() {
        this.seats = new LinkedList<>();
        this.seatState = new HashMap<>();
        for (int r = 1; r <= 9; r++) {
            List<Seat> row = new LinkedList<>();
            for (int c = 1; c <= 9; c++) {
                Seat seat = new Seat(r, c);
                row.add(seat);
                seatState.put(seat, true);
            }
            this.seats.add(row);
        }
    }

    public List<List<Seat>> getAllSeats() {
        return this.seats;
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> available = new LinkedList<>();
        for (List<Seat> row : this.seats) {
            for (Seat seat: row) {
                if (this.seatState.get(seat)) {
                    available.add(seat);
                }
            }
        }
        return available;
    }
}
