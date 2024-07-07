package com.betest.gsolusindo.services;

import org.springframework.stereotype.Service;

import com.betest.gsolusindo.models.Booking;
import com.betest.gsolusindo.models.Consumtion;
import com.betest.gsolusindo.models.ConsumtionBooking;
import com.betest.gsolusindo.repositories.ConsumtionBookingRepository;

@Service
public class ConsumtionBookingService {

    private final ConsumtionBookingRepository consumtionBookingRepository;

    public ConsumtionBookingService(ConsumtionBookingRepository consumtionBookingRepository) {
        this.consumtionBookingRepository = consumtionBookingRepository;
    }

    public ConsumtionBooking saveConsumtionBooking(Booking booking, Consumtion consumtions, int amount) {
        ConsumtionBooking consumtionBooking = new ConsumtionBooking(booking, consumtions, amount);
        return consumtionBookingRepository.save(consumtionBooking);
    }
}
