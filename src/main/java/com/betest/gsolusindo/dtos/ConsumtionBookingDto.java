package com.betest.gsolusindo.dtos;

import java.util.UUID;

import com.betest.gsolusindo.models.ConsumtionBooking;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConsumtionBookingDto(
        UUID bookingId,
        UUID consumtionId,
        int amount) {

    public static ConsumtionBookingDto toDto(ConsumtionBooking entity) {
        ConsumtionBookingDto dto = new ConsumtionBookingDto(
                entity.getBooking().getId(),
                entity.getConsumtion().getId(),
                entity.getAmount());
        return dto;
    }

    public static ConsumtionBookingDto toDto(UUID consumtionId, int amount) {
        ConsumtionBookingDto dto = new ConsumtionBookingDto(
                null,
                consumtionId,
                amount);
        return dto;
    }
}
