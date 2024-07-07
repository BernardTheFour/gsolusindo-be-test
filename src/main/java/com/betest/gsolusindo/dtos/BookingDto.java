package com.betest.gsolusindo.dtos;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.betest.gsolusindo.models.Booking;
import com.betest.gsolusindo.models.Consumtion;

public record BookingDto(
        UUID id,
        String officeName,
        String roomName,
        int participants,
        Instant startTime,
        Instant endTime,
        Instant bookingDate,
        Set<UUID> consumtionIds) {

    public static BookingDto toDto(Booking entity) {
        Set<UUID> consumtionIds = entity.getConsumtions()
                .stream()
                .map(Consumtion::getId)
                .collect(Collectors.toSet());

        BookingDto dto = new BookingDto(
                entity.getId(),
                entity.getOfficeName(),
                entity.getRoomName(),
                entity.getParticipants(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getBookingDate(),
                consumtionIds);
        return dto;
    }
}