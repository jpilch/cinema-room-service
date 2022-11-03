package com.example.cinemaroomservice;

public class SeatLocation {
    private int row;
    private int column;

    public SeatLocation(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public SeatLocation() {}

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isValid() {
        return this.column <= 9 && this.column >= 1 && this.row >= 1 && this.row <= 9;
    }
}
