package com.example.cinemaroomservice;

public class Seat {
    final SeatLocation seatLocation;
    private final int price;

    public Seat(int row, int column) {
        this.seatLocation = new SeatLocation(row, column);
        this.price =
                this.seatLocation.getRow() <= 4 ? 10 : 8;
    }

    public int getRow() {
        return this.seatLocation.getRow();
    }

    public int getColumn() {
        return this.seatLocation.getColumn();
    }

    public int getPrice() {
        return this.price;
    }
}
