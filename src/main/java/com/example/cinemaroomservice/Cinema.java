package com.example.cinemaroomservice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Cinema {
    private final List<Seat> seats;
    private final HashMap<Seat, Boolean> seatState;
    public Cinema() {
        this.seats = new LinkedList<>();
        this.seatState = new HashMap<>();
        for (int r = 1; r <= 9; r++) {
            for (int c = 1; c <= 9; c++) {
                Seat seat = new Seat(r, c);
                this.seats.add(seat);
                seatState.put(seat, true);
            }
        }
    }
    public Seat makeReservation(SeatLocation seatLocation) {
        Seat chosenSeat = null;
        for (Seat seat : this.seats) {
            if (seat.getColumn() == seatLocation.getColumn()
                    && seat.getRow() == seatLocation.getColumn()) {
                chosenSeat = seat;
                break;
            }
        }
        if (chosenSeat != null && this.seatState.get(chosenSeat)) {
            this.seatState.put(chosenSeat, false);
            return chosenSeat;
        }
        return null;
    }

    public AvailableSeats getAvailableSeats() {
        HashSet<Integer> availableRowsSet = new HashSet<>();
        HashSet<Integer> availableColumnsSet = new HashSet<>();
        List<Seat> availableSeats = new LinkedList<>();
        for (Seat seat : this.seats) {
            if (this.seatState.get(seat)) {
                availableSeats.add(seat);
                availableRowsSet.add(seat.getRow());
                availableColumnsSet.add(seat.getColumn());
            }
        }
        return new AvailableSeats(
                availableRowsSet.size(),
                availableColumnsSet.size(),
                availableSeats
        );
    }
}
