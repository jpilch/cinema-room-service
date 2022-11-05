package com.example.cinemaroomservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController {
    private final Cinema cinema = new Cinema();

    @GetMapping("/seats")
    public ResponseEntity<AvailableSeats> getSeats() {
        return new ResponseEntity<>(this.cinema.getAvailableSeats(), HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> makeReservation(@RequestBody Seat seat) {
        if (!seat.isValid()) {
            return new ResponseEntity<>(
                    Map.of(
                            "error",
                            "The number of a row or a column is out of bounds!"
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
        Ticket reservedTicket = this.cinema.makeReservation(seat);
        if (reservedTicket != null) {
            String token = UUID.randomUUID().toString();
            this.cinema.addToken(token, reservedTicket);
            return new ResponseEntity<>(
                    Map.of(
                            "token", token,
                            "ticket", reservedTicket
                    ),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                Map.of("error", "The ticket has been already purchased!"),
                HttpStatus.BAD_REQUEST
        );
    }

    @PostMapping("/return")
    public ResponseEntity<?> refundTicket(@RequestBody TicketToken token) {
        Ticket refundedTicket = this.cinema.refundTicket(token.getToken());
        if (refundedTicket != null) {
            return new ResponseEntity<>(
                Map.of("returned_ticket", refundedTicket),
                HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                Map.of("error", "Wrong token!"),
                HttpStatus.BAD_REQUEST
        );
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStatistics(@RequestParam(required = false) String password) {
        if (password == null || !password.equals("super_secret")) {
            return new ResponseEntity<>(
                    Map.of("error", "The password is wrong!"),
                    HttpStatus.UNAUTHORIZED
            );
        }
        return new ResponseEntity<>(
                this.cinema.getStatistics(),
                HttpStatus.OK
        );
    }
}
