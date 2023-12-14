package com.vdc.fresh.smartmenu.data.repository;

import com.vdc.fresh.smartmenu.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Iterable<Reservation> findAllByReservationDate(Date date);
}