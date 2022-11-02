package com.example.cinemaroomservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CinemaController {
    private final Cinema cinema = new Cinema();

    @GetMapping("/seats")
    public ResponseEntity<Map<String, Object>> getSeats() {
        Map<String, Object> res = new HashMap<>();
        res.put("total_rows", 9);
        res.put("total_columns", 9);
        res.put("available_seats", this.cinema.getAvailableSeats());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
