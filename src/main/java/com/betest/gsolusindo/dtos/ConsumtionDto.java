package com.betest.gsolusindo.dtos;

import java.time.Instant;
import java.util.UUID;

import com.betest.gsolusindo.models.Consumtion;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConsumtionDto(
        UUID id,
        String name,
        int maxPrice,
        Instant createdAt) {

    public static ConsumtionDto toDto(Consumtion entity) {
        ConsumtionDto dto = new ConsumtionDto(
                entity.getId(),
                entity.getName(),
                entity.getMaxPrice(),
                entity.getCreatedAt());
        return dto;
    }
}
