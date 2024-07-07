package com.betest.gsolusindo.services;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.betest.gsolusindo.dtos.BookingDto;
import com.betest.gsolusindo.dtos.BookingSummaryDto;
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
                dto.office_name(),
                dto.room_name(),
                dto.participants(),
                dto.start_time(),
                dto.end_time(),
                dto.booking_date());

        Booking booking = bookingRepository.save(entity);

        // get consumtion and save the ConsumtionBooking
        dto.consumtion_bookings()
                .stream()
                .forEach((consumtionBooking) -> {
                    Consumtion consumtion = consumtionService.getById(consumtionBooking.consumtion_id());
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

    public List<BookingSummaryDto> getSummaries(int year, int month) {

        List<Booking> bookings = bookingRepository.findBookingByYearAndMonth(year, month);

        return null;
    }
}
