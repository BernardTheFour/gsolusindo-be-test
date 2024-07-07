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
        String officeName,
        String roomName,
        int participants,
        Instant startTime,
        Instant endTime,
        Instant bookingDate,
        Set<ConsumtionBookingDto> consumtionBookingsDto) {

    public static BookingDto toDto(Booking entity) {
        Set<ConsumtionBookingDto> consumtionBookingDtos = entity.getConsumtionBookings()
                .stream()
                .map((consumtionBooking) -> ConsumtionBookingDto.toDto(
                        consumtionBooking.getConsumtion().getId(),
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
