package com.betest.gsolusindo.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betest.gsolusindo.dtos.BookingDto;
import com.betest.gsolusindo.models.Booking;
import com.betest.gsolusindo.models.Consumtion;
import com.betest.gsolusindo.repositories.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private final ConsumtionService consumtionService;

    public BookingService(BookingRepository bookingRepository, ConsumtionService consumtionService) {
        this.bookingRepository = bookingRepository;
        this.consumtionService = consumtionService;
    }

    public Booking saveBooking(BookingDto dto) {
        Set<Consumtion> consumtions = dto.consumtionIds()
                .stream()
                .map((id) -> consumtionService.getById(id))
                .collect(Collectors.toSet());

        Booking booking = new Booking(
                dto.id(),
                dto.officeName(),
                dto.roomName(),
                dto.participants(),
                dto.startTime(),
                dto.endTime(),
                dto.bookingDate(),
                consumtions);

        return bookingRepository.save(booking);
    }
}
