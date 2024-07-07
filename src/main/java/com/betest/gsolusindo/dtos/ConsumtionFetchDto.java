package com.betest.gsolusindo.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConsumtionFetchDto(
        int id,
        String name,
        int maxPrice,
        Instant createdAt) {
}
