package com.vdc.fresh.smartmenu.Web.api;

import com.vdc.fresh.smartmenu.Web.exception.BadRequestException;
import com.vdc.fresh.smartmenu.Web.exception.NotFoundException;
import com.vdc.fresh.smartmenu.data.entity.Room;
import com.vdc.fresh.smartmenu.data.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {
    private final RoomRepository roomRepository;

    public RoomApiController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @GetMapping
    public List<Room> getAllRooms(){
        return this.roomRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room creatRoom(@RequestBody Room room){
        return this.roomRepository.save(room);
    }
    @GetMapping("/{id}")
    public  Room getRoom(@PathVariable("id")long id){
        Optional<Room> room = this.roomRepository.findById(id);
        if (room.isEmpty()){
            throw new NotFoundException("room not fount with id: "+ id);
        }
        return room.get();
    }
    @PutMapping("/{id}")
    public  Room updateRoom(@PathVariable("id")long id, @RequestBody Room room) {
        if (id != room.getId()){
            throw new BadRequestException("id on path doesn't match boddy");
        }
        return this.roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    public  void deleteRoom(@PathVariable("id")long id) {
        this.roomRepository.deleteById(id);
    }

}
