package com.example.cinemaroomservice;

import java.util.*;

public class Cinema {
    private final List<Seat> seats;
    private final HashMap<Seat, Boolean> seatState;
    private final HashMap<Seat, Ticket> tickets;
    private final HashMap<String, Ticket> tokens;
    public Cinema() {
        this.tokens = new HashMap<>();
        this.seats = new LinkedList<>();
        this.seatState = new HashMap<>();
        this.tickets = new HashMap<>();
        for (int r = 1; r <= 9; r++) {
            for (int c = 1; c <= 9; c++) {
                Seat seat = new Seat(r, c);
                this.seats.add(seat);
                seatState.put(seat, true);
                tickets.put(seat, new Ticket(seat));
            }
        }
    }
    public Ticket makeReservation(Seat chosenSeat) {
        for (Seat seat : this.seats) {
            if (chosenSeat.equals(seat) && this.seatState.get(seat)) {
                this.seatState.put(seat, false);
                return this.tickets.get(seat);
            }
        }
        return null;
    }

    public AvailableSeats getAvailableSeats() {
        HashSet<Integer> availableRowsSet = new HashSet<>();
        HashSet<Integer> availableColumnsSet = new HashSet<>();
        List<Ticket> availableTickets = new LinkedList<>();
        for (Seat seat : this.seats) {
            if (this.seatState.get(seat)) {
                availableTickets.add(this.tickets.get(seat));
                availableRowsSet.add(seat.getRow());
                availableColumnsSet.add(seat.getColumn());
            }
        }
        return new AvailableSeats(
                availableRowsSet.size(),
                availableColumnsSet.size(),
                availableTickets
        );
    }

    public void addToken(String token, Ticket ticket) {
        this.tokens.put(token, ticket);
    }

    public Ticket refundTicket(String token) {
        Ticket ticket = this.tokens.get(token);
        if (ticket != null) {
            this.tokens.remove(token);
            this.seatState.put(ticket.seat, true);
        }
        return ticket;
    }

    public Map<String, Integer> getStatistics() {
        int currentIncome = 0;
        for (String token : this.tokens.keySet()) {
            currentIncome += this.tokens.get(token).getPrice();
        }
        return Map.of(
                "current_income", currentIncome,
                "number_of_available_seats", this.getAvailableSeats().getAvailableSeats().size(),
                "number_of_purchased_tickets", this.tokens.keySet().size()
        );
    }
}
