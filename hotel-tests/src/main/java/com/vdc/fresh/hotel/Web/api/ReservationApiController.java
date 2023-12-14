package com.vdc.fresh.smartmenu.Web.api;

import com.vdc.fresh.smartmenu.Web.exception.BadRequestException;
import com.vdc.fresh.smartmenu.Web.exception.NotFoundException;
import com.vdc.fresh.smartmenu.data.entity.Guest;
import com.vdc.fresh.smartmenu.data.entity.Reservation;
import com.vdc.fresh.smartmenu.data.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {
    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return this.reservationRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation reservationRoom(@RequestBody Reservation reservation){
        return this.reservationRepository.save(reservation);
    }
    @GetMapping("/{id}")
    public  Reservation getReservation(@PathVariable("id")long id){
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        if (reservation.isEmpty()){
            throw new NotFoundException("reservation not fount with id: "+ id);
        }
        return reservation.get();
    }
    @PutMapping("/{id}")
    public  Reservation updateReservation(@PathVariable("id")long id, @RequestBody Reservation reservation) {
        if (id != reservation.getReservationId()){
            throw new BadRequestException("id on path doesn't match boddy");
        }
        return this.reservationRepository.save(reservation);
    }
    @DeleteMapping("/{id}")
    public  void deleteReservation(@PathVariable("id")long id) {
        this.reservationRepository.deleteById(id);
    }


}
