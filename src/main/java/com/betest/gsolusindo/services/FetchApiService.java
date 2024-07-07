package com.betest.gsolusindo.services;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.betest.gsolusindo.dtos.BookingFetchDto;
import com.betest.gsolusindo.dtos.ConsumtionDto;
import com.betest.gsolusindo.dtos.ConsumtionFetchDto;
import com.betest.gsolusindo.models.Consumtion;

@Service
public class FetchApiService {
    private final WebClient webClient;

    private final ConsumtionService consumtionService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public FetchApiService(WebClient.Builder webClientBuilder, ConsumtionService consumtionService) {
        this.webClient = webClientBuilder.build();
        this.consumtionService = consumtionService;
    }

    public void fetchConsumtionData() {
        String consumtionUri = "https://6686cb5583c983911b03a7f3.mockapi.io/api/dummy-data/masterJenisKonsumsi";

        List<ConsumtionFetchDto> response = webClient.get()
                .uri(consumtionUri)
                .retrieve()
                .bodyToFlux(ConsumtionFetchDto.class)
                .collectList()
                .block();

        response.stream()
                .forEach((data) -> {
                    ConsumtionDto dto = new ConsumtionDto(
                            UUID.randomUUID(),
                            data.name(),
                            data.maxPrice(),
                            data.createdAt());

                    consumtionService.saveConsumtion(dto);
                });
    }

    public void fetchBookingData() {
        String bookingUri = "https://66876cc30bc7155dc017a662.mockapi.io/api/dummy-data/bookingList";

        List<BookingFetchDto> response = webClient.get()
                .uri(bookingUri)
                .retrieve()
                .bodyToFlux(BookingFetchDto.class)
                .collectList()
                .block();

    }
}
