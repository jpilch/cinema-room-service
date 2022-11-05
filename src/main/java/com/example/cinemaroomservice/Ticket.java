package com.example.cinemaroomservice;

public class Ticket {
    final Seat seat;
    private final int price;

    public Ticket(Seat seat) {
        this.seat = seat;
        this.price =
                this.seat.getRow() <= 4 ? 10 : 8;
    }

    public int getRow() {
        return this.seat.getRow();
    }

    public int getColumn() {
        return this.seat.getColumn();
    }

    public int getPrice() {
        return this.price;
    }
}
