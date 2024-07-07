package com.betest.gsolusindo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.betest.gsolusindo.dtos.BookingSummaryDto;
import com.betest.gsolusindo.services.BookingService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/summaries")
    public ResponseEntity<List<BookingSummaryDto>> getBookingSummaries(
            @RequestParam(name = "year", defaultValue = "2024") int year,
            @RequestParam(name = "month", defaultValue = "1") int month) {
        List<BookingSummaryDto> dto = bookingService.getSummaries(year, month);

        return ResponseEntity.ok(dto);
    }
}
