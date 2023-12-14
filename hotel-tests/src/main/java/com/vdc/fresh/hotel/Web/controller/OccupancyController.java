package com.vdc.fresh.smartmenu.Web.controller;

import com.vdc.fresh.smartmenu.service.RoomReservationService;
import io.micrometer.common.util.StringUtils;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/occupancy")
public class OccupancyController {
    private final RoomReservationService service;

    public OccupancyController(RoomReservationService service) {
        this.service = service;
    }

    @GetMapping
    public String getOccupancy(Model model, @RequestParam(value = "date", required = false) String dateString){
        Date date = new Date();
        if(StringUtils.isNotEmpty(dateString)){
            try{
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                date = format.parse(dateString);
            }catch (Exception e){
                //TODO
            }
        }
        model.addAttribute("date",date);
        model.addAttribute("reservation", this.service.getRoomReservationsForDate(dateString));
        return "occupancy";
    }
}
