package com.betest.gsolusindo.models;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumtions")
public class Consumtion {

    @Id
    @GeneratedValue(generator = "consumtions_uuid")
    @Column(unique = true, name = "id")
    UUID id;

    @Column(unique = true, name = "name", length = 100)
    String name;

    @Column(name = "max_price")
    int maxPrice;

    @CreatedDate
    Instant createdAt;

    @ManyToMany(mappedBy = "consumtions")
    Set<Booking> bookings;

    public Consumtion() {
    }

    public Consumtion(UUID id, String name, int maxPrice, Instant createdAt, Set<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.maxPrice = maxPrice;
        this.createdAt = createdAt;
        this.bookings = bookings;
    }

    public Consumtion(String name, int maxPrice, Instant createdAt) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.createdAt = createdAt;
    }

    public Consumtion(String name, int maxPrice, Instant createdAt, Set<Booking> bookings) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.createdAt = createdAt;
        this.bookings = bookings;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
