package com.vdc.fresh.smartmenu.data.repository;

import com.vdc.fresh.smartmenu.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long>{
    List<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
