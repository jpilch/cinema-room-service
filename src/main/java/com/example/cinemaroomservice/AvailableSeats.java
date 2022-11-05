package com.example.cinemaroomservice;

import java.util.List;

public class AvailableSeats {
    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Ticket> getAvailableSeats() {
        return availableTickets;
    }

    public void setAvailableSeats(List<Ticket> availableTickets) {
        this.availableTickets = availableTickets;
    }

    private int totalRows;
    private int totalColumns;
    private List<Ticket> availableTickets;

    public AvailableSeats(
            int totalRows,
            int totalColumns,
            List<Ticket> availableTickets) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableTickets = availableTickets;
    }

}
