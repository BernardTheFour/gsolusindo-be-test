package com.betest.gsolusindo.services;

import java.util.Set;
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

    public ConsumtionBooking saveConsumtionBooking(
            Booking booking,
            Consumtion consumtions,
            int amount) {

        ConsumtionBooking consumtionBooking = new ConsumtionBooking(
                booking, consumtions, amount);
        return consumtionBookingRepository.save(consumtionBooking);
    }

    public int getTotalCostFromBooking(Booking booking) {
        Set<ConsumtionBooking> consumtionBookings = booking.getConsumtionBookings();

        int totalCost = consumtionBookings
                .stream()
                .mapToInt((consumtionBooking) -> {
                    int participants = booking.getParticipants();
                    int amount = consumtionBooking.getAmount();
                    int maxPrice = consumtionBooking.getConsumtion().getMaxPrice();

                    // break potential: result could exceed 2,147,483,647 max integer
                    return participants * amount * maxPrice;
                })
                .sum();

        return totalCost;
    }
}
