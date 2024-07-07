package com.betest.gsolusindo.models;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @Column(name = "created_at")
    Instant createdAt;

    @OneToMany(mappedBy = "consumtion", fetch = FetchType.LAZY)
    Set<ConsumtionBooking> consumtionBookings;

    public Consumtion() {
    }

    public Consumtion(UUID id, String name, int maxPrice, Instant createdAt,
            Set<ConsumtionBooking> consumtionBookings) {
        this.id = id;
        this.name = name;
        this.maxPrice = maxPrice;
        this.createdAt = createdAt;
        this.consumtionBookings = consumtionBookings;
    }

    public Consumtion(String name, int maxPrice, Instant createdAt) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.createdAt = createdAt;
    }

    public Consumtion(String name, int maxPrice, Instant createdAt, Set<ConsumtionBooking> consumtionBookings) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.createdAt = createdAt;
        this.consumtionBookings = consumtionBookings;
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

    public Set<ConsumtionBooking> getBookings() {
        return consumtionBookings;
    }

    public void setBookings(Set<ConsumtionBooking> consumtionBookings) {
        this.consumtionBookings = consumtionBookings;
    }
}
