package com.betest.gsolusindo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.betest.gsolusindo.dtos.BookingFetchDto;
import com.betest.gsolusindo.dtos.ConsumtionFetchDto;

@Service
public class FetchApiService {
    private final WebClient webClient;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public FetchApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public void fetchConsumtionData() {
        String consumtionUri = "https://6686cb5583c983911b03a7f3.mockapi.io/api/dummy-data/masterJenisKonsumsi";

        List<ConsumtionFetchDto> response = webClient.get()
                .uri(consumtionUri)
                .retrieve()
                .bodyToFlux(ConsumtionFetchDto.class)
                .collectList()
                .block();

        logger.info("Consumtion data size: " + response.size());
        logger.info("Example Consumtion data: " + response.get(0).toString());
    }

    public void fetchBookingData() {
        String bookingUri = "https://66876cc30bc7155dc017a662.mockapi.io/api/dummy-data/bookingList";

        List<BookingFetchDto> response = webClient.get()
                .uri(bookingUri)
                .retrieve()
                .bodyToFlux(BookingFetchDto.class)
                .collectList()
                .block();

        logger.info("Consumtion data size: " + response.size());
        logger.info("Example Consumtion data: " + response.get(0).toString());
    }
}
