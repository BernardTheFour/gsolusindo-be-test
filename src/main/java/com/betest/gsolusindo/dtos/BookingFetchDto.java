package com.betest.gsolusindo.dtos;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookingFetchDto(
        int id,
        String officeName,
        String roomName,
        int participants,
        Instant startTime,
        Instant endTime,
        Instant bookingDate,
        List<ConsumtionNameFetchDto> listConsumption) {
}