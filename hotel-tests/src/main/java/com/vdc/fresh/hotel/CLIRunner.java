//package com.vdc.fresh.smartmenu;
//
//import com.vdc.fresh.smartmenu.data.entity.Guest;
//import com.vdc.fresh.smartmenu.data.entity.Reservation;
//import com.vdc.fresh.smartmenu.data.entity.Room;
//import com.vdc.fresh.smartmenu.data.repository.GuestRepository;
//import com.vdc.fresh.smartmenu.data.repository.ReservationRepository;
//import com.vdc.fresh.smartmenu.data.repository.RoomRepository;
//import com.vdc.fresh.smartmenu.service.RoomReservationService;
//import com.vdc.fresh.smartmenu.service.model.RoomReservation;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class CLIRunner implements CommandLineRunner {
//    private  final RoomRepository roomRepository;
//    private  final ReservationRepository reservationRepository;
//    private final GuestRepository guestRepository;
//    private final RoomReservationService roomReservationService;
//    public CLIRunner(RoomRepository roomRepository, ReservationRepository reservationRepository, GuestRepository guestRepository, RoomReservationService roomReservationService) {
//        this.roomRepository = roomRepository;
//        this.reservationRepository = reservationRepository;
//        this.guestRepository = guestRepository;
//        this.roomReservationService = roomReservationService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
////        System.out.println("****** GUEST ******");
////        List<Guest> guests = this.guestRepository.findAll();
////        guests.forEach(System.out::println);
////
////        System.out.println("****** ROOMS ******");
////        List<Room> rooms = this.roomRepository.findAll();
////        rooms.forEach(System.out::println);
////        //Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
////
////        System.out.println("****** RESERVATIONS ******");
////        List<Reservation> reservations = this.reservationRepository.findAll();
////        reservations.forEach(System.out::println);
//
//        List<RoomReservation> reservations = this.roomReservationService.getRoomReservationsForDate("2023-08-28");
//        reservations.forEach(System.out::println);
//
//    }
//}
