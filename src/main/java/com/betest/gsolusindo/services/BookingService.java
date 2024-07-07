package com.betest.gsolusindo.services;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.betest.gsolusindo.dtos.BookingDto;
import com.betest.gsolusindo.models.Booking;
import com.betest.gsolusindo.models.Consumtion;
import com.betest.gsolusindo.repositories.BookingRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private final ConsumtionService consumtionService;

    private final ConsumtionBookingService consumtionBookingService;

    public BookingService(BookingRepository bookingRepository, ConsumtionService consumtionService,
            ConsumtionBookingService consumtionBookingService) {
        this.bookingRepository = bookingRepository;
        this.consumtionService = consumtionService;
        this.consumtionBookingService = consumtionBookingService;
    }

    public Booking saveBookingWithConsumtions(BookingDto dto) {
        // save and get the booking
        Booking entity = new Booking(
                dto.id(),
                dto.officeName(),
                dto.roomName(),
                dto.participants(),
                dto.startTime(),
                dto.endTime(),
                dto.bookingDate());

        Booking booking = bookingRepository.save(entity);

        // get consumtion and save the ConsumtionBooking
        dto.consumtionBookingsDto()
                .stream()
                .forEach((consumtionBooking) -> {
                    Consumtion consumtion = consumtionService.getById(consumtionBooking.consumtionId());
                    consumtionBookingService.saveConsumtionBooking(booking, consumtion, consumtionBooking.amount());
                });

        // return new booking attached to consumtions
        return getById(booking.getId());
    }

    public Booking getById(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found"));

        return booking;
    }
}
