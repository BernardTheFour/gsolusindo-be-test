package com.betest.gsolusindo.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumtion_booking")
public class ConsumtionBooking {
    @Id
    @GeneratedValue(generator = "consumtion_booking_uuid")
    @Column(unique = true, name = "id")
    UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumtion_id")
    Consumtion consumtion;

    int amount;

    public ConsumtionBooking() {
    }

    public ConsumtionBooking(Booking booking, Consumtion consumtion, int amount) {
        this.booking = booking;
        this.consumtion = consumtion;
        this.amount = amount;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Consumtion getConsumtion() {
        return consumtion;
    }

    public void setConsumtion(Consumtion consumtion) {
        this.consumtion = consumtion;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
