package com.betest.gsolusindo.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.betest.gsolusindo.services.FetchApiService;

@Component
public class StartupRunner implements CommandLineRunner {

    private final FetchApiService fetchApiService;

    public StartupRunner(FetchApiService fetchApiService) {
        this.fetchApiService = fetchApiService;
    }

    @Override
    public void run(String... args) throws Exception {
        fetchApiService.fetchConsumtionData();
        fetchApiService.fetchBookingData();
    }
}
