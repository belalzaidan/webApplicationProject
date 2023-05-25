package com.example.ordinaer2022;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestillingRepo extends JpaRepository<Bestilling,Long> {
    List<Bestilling> findByTelefon(String telefon);
}
