package com.example.cinemaroomservice;

public class Seat {
    private int row;
    private int column;
    private boolean available;

    public Seat(int row, int col) {
        this.row = row;
        this.column = col;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

}
