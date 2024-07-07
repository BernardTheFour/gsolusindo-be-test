package com.betest.gsolusindo.dtos;

import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConsumtionDto(
        UUID id,
        String name,
        int max_price,
        Instant created_at) {
}
