package com.vdc.fresh.smartmenu.Web.api;

import com.vdc.fresh.smartmenu.Web.exception.BadRequestException;
import com.vdc.fresh.smartmenu.Web.exception.NotFoundException;
import com.vdc.fresh.smartmenu.data.entity.Guest;
import com.vdc.fresh.smartmenu.data.repository.GuestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {
    private final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
    @GetMapping
    public List<Guest> getAllRooms(){
        return this.guestRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest guestRoom(@RequestBody Guest guest){
        return this.guestRepository.save(guest);
    }
    @GetMapping("/{id}")
    public  Guest getGuest(@PathVariable("id")long id){
        Optional<Guest> guest = this.guestRepository.findById(id);
        if (guest.isEmpty()){
            throw new NotFoundException("room not fount with id: "+ id);
        }
        return guest.get();
    }
    @PutMapping("/{id}")
    public  Guest updateGuest(@PathVariable("id")long id, @RequestBody Guest guest) {
        if (id != guest.getId()){
            throw new BadRequestException("id on path doesn't match boddy");
        }
        return this.guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    public  void deleteGuest(@PathVariable("id")long id) {
        this.guestRepository.deleteById(id);
    }

}

