package com.betest.gsolusindo.dtos;

import java.time.Instant;
import java.util.List;

public record BookingFetchDto(
        int id,
        String officeName,
        String roomName,
        int participants,
        Instant startTime,
        Instant endTime,
        Instant bookingDate,
        List<ConsumtionName> listConsumption) {
}

record ConsumtionName(
        String name) {

}