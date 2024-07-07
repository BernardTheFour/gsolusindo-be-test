package com.betest.gsolusindo.dtos;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.betest.gsolusindo.models.Booking;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookingDto(
        UUID id,
        String office_name,
        String room_name,
        int participants,
        Instant start_time,
        Instant end_time,
        Instant booking_date,
        Set<ConsumtionBookingDto> consumtion_bookings) {

    public static BookingDto toDto(Booking entity) {
        Set<ConsumtionBookingDto> consumtionBookingDtos = entity.getConsumtionBookings()
                .stream()
                .map((consumtionBooking) -> ConsumtionBookingDto.toDto(
                        consumtionBooking.getConsumtion(),
                        consumtionBooking.getAmount()))
                .collect(Collectors.toSet());

        BookingDto dto = new BookingDto(
                entity.getId(),
                entity.getOfficeName(),
                entity.getRoomName(),
                entity.getParticipants(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getBookingDate(),
                consumtionBookingDtos);

        return dto;
    }
}
