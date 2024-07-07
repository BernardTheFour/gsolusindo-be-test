package com.betest.gsolusindo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookingSummaryDto(
        BookingDto booking,
        float room_capacity,
        int consumtion_cost) {

    public static BookingSummaryDto toDto(
            BookingDto bookingDto,
            float roomCapacity,
            int consumtionCost) {
        BookingSummaryDto dto = new BookingSummaryDto(
                bookingDto,
                roomCapacity,
                consumtionCost);

        return dto;
    }
}
