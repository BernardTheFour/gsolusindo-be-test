package com.betest.gsolusindo.dtos;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.betest.gsolusindo.models.Booking;
import com.betest.gsolusindo.models.Consumtion;

public record BookingFetchDto(
        UUID id,
        String officeName,
        String roomName,
        int participants,
        Instant startTime,
        Instant endTime,
        Instant bookingDate,
        Set<String> consumtionNames) {

    public static BookingFetchDto toDto(Booking entity) {
        Set<String> consumtionIds = entity.getConsumtions()
                .stream()
                .map(Consumtion::getName)
                .collect(Collectors.toSet());

        BookingFetchDto dto = new BookingFetchDto(
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