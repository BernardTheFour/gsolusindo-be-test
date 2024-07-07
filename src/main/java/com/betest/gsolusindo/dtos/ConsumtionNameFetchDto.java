package com.betest.gsolusindo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConsumtionNameFetchDto(
        String name) {

}