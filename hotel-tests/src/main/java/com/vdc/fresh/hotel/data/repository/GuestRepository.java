package com.vdc.fresh.smartmenu.data.repository;

import com.vdc.fresh.smartmenu.data.entity.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}