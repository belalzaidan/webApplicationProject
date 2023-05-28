package com.example.ordinaer2022;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    List<Reservation> findByPhone(String phone);
    List<Reservation> findByEmail(String email);
}
