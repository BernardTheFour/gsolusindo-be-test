package com.betest.gsolusindo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betest.gsolusindo.models.Booking;

@Repository
public interface BookingRepository extends ListCrudRepository<Booking, UUID> {

    @Query(" SELECT booking FROM Booking booking " +
            " WHERE (YEAR(booking.startTime)) = :year AND (MONTH(booking.startTime)) = :month " +
            " OR (YEAR(booking.endTime)) = :year AND (MONTH(booking.endTime)) = :month ")
    List<Booking> findBookingByYearAndMonth(
            @Param("year") int year,
            @Param("month") int month);
}
