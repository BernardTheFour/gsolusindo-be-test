package com.betest.gsolusindo.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.betest.gsolusindo.models.Booking;

@Repository
public interface BookingRepository extends ListCrudRepository<Booking, UUID> {

}
