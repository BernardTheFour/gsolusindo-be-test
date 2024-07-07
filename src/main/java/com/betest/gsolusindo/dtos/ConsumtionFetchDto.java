package com.betest.gsolusindo.dtos;

import java.time.Instant;

public record ConsumtionFetchDto(
        int id,
        String name,
        int maxPrice,
        Instant createdAt) {
}
