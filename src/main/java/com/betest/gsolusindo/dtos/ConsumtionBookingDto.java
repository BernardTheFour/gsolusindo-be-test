package com.betest.gsolusindo.dtos;

import java.util.UUID;

import com.betest.gsolusindo.models.Consumtion;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConsumtionBookingDto(
        UUID consumtion_id,
        String consumtion_name,
        int amount) {

    public static ConsumtionBookingDto toDto(Consumtion consumtion, int amount) {
        ConsumtionBookingDto dto = new ConsumtionBookingDto(
                consumtion.getId(),
                consumtion.getName(),
                amount);
        return dto;
    }
}
