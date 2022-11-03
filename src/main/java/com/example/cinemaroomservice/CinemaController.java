package com.example.cinemaroomservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CinemaController {
    private final Cinema cinema = new Cinema();

    @GetMapping("/seats")
    public ResponseEntity<AvailableSeats> getSeats() {
        return new ResponseEntity<>(this.cinema.getAvailableSeats(), HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> makeReservation(@RequestBody SeatLocation seatLocation) {
        if (!seatLocation.isValid()) {
            return new ResponseEntity<>(
                    Map.of("error", "The number of a row or a column is out of bounds!"),
                    HttpStatus.BAD_REQUEST
            );
        }
        Seat reservedSeat = this.cinema.makeReservation(seatLocation);
        if (reservedSeat != null) {
            return new ResponseEntity<>(reservedSeat, HttpStatus.OK);
        }
        return new ResponseEntity<>(
                Map.of("error", "The ticket has been already purchased!"),
                HttpStatus.BAD_REQUEST
        );
    }
}
