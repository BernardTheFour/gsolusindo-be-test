package com.betest.gsolusindo.models;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(generator = "bookings_uuid")
    @Column(unique = true, name = "id")
    UUID id;

    @Column(name = "office_name", length = 100)
    String officeName;

    @Column(name = "room_name", length = 100)
    String roomName;

    @Column(name = "participant_count")
    int participants;

    @Column(name = "start_time")
    Instant startTime;

    @Column(name = "end_time")
    Instant endTime;

    @Column(name = "booking_date")
    Instant bookingDate;

    @ManyToMany
    @JoinTable(
        name = "booking_consumtion", 
        joinColumns = @JoinColumn(name = "booking_id"), 
        inverseJoinColumns = @JoinColumn(name = "consumtion_id")
    )
    Set<Consumtion> consumtions;

    public Booking() {
    }

    public Booking(UUID id, String officeName, String roomName, int participants, Instant startTime, Instant endTime,
            Instant bookingDate, Set<Consumtion> consumtions) {
        this.id = id;
        this.officeName = officeName;
        this.roomName = roomName;
        this.participants = participants;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingDate = bookingDate;
        this.consumtions = consumtions;
    }

    public Booking(String officeName, String roomName, int participants, Instant startTime, Instant endTime,
            Instant bookingDate, Set<Consumtion> consumtions) {
        this.officeName = officeName;
        this.roomName = roomName;
        this.participants = participants;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingDate = bookingDate;
        this.consumtions = consumtions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Instant getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Instant bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Set<Consumtion> getConsumtions() {
        return consumtions;
    }

    public void setConsumtions(Set<Consumtion> consumtions) {
        this.consumtions = consumtions;
    }
}
