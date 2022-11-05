package com.example.cinemaroomservice;

public class Seat {
    private int row;
    private int column;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Seat() {}

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isValid() {
        return this.column <= 9 && this.column >= 1 && this.row >= 1 && this.row <= 9;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        final Seat seat = (Seat) o;
        return this.getRow() == seat.getRow()
                && this.getColumn() == seat.getColumn();
    }
}
