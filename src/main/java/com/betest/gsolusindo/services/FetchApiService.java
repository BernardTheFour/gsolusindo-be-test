package com.betest.gsolusindo.services;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.betest.gsolusindo.dtos.BookingDto;
import com.betest.gsolusindo.dtos.BookingFetchDto;
import com.betest.gsolusindo.dtos.ConsumtionBookingDto;
import com.betest.gsolusindo.dtos.ConsumtionDto;
import com.betest.gsolusindo.dtos.ConsumtionFetchDto;

@Service
public class FetchApiService {
    private final WebClient webClient;

    private final ConsumtionService consumtionService;
    private final BookingService bookingService;

    public FetchApiService(WebClient.Builder webClientBuilder, ConsumtionService consumtionService,
            BookingService bookingService) {
        this.webClient = webClientBuilder.build();
        this.consumtionService = consumtionService;
        this.bookingService = bookingService;
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

        response.stream()
                .forEach((data) -> {
                    UUID bookingUUID = UUID.randomUUID();
                    Set<ConsumtionBookingDto> consumtionBookingsDto = data.listConsumption()
                            .stream()
                            .map(consumtion -> {
                                ConsumtionBookingDto dto = new ConsumtionBookingDto(
                                        bookingUUID,
                                        consumtionService.getByName(consumtion.name()).getId(),
                                        data.participants());
                                return dto;
                            })
                            .collect(Collectors.toSet());

                    BookingDto dto = new BookingDto(
                            bookingUUID,
                            data.officeName(),
                            data.roomName(),
                            data.participants(),
                            data.startTime(),
                            data.endTime(),
                            data.bookingDate(),
                            consumtionBookingsDto);

                    bookingService.saveBookingWithConsumtions(dto);
                });
    }
}
