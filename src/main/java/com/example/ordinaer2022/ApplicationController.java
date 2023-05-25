package com.example.ordinaer2022;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {

    // public List<Bestilling> bestillinger = new ArrayList<>();
    @Autowired
    BestillingRepo rep;

    @Autowired
    PersonRepo prep;

    @GetMapping("/sjekk")
    public String sjekk(){
        return "OK";
    }



    @PostMapping("/lagre")
    public void lagreBestilling (Bestilling innBestilling){
        rep.save(innBestilling);
    }

    @GetMapping("/sjekk/{telefon}")
    public boolean sjekkTelefon (@PathVariable String telefon){
        List<Bestilling> bestilling = rep.findByTelefon(telefon);
        return bestilling.isEmpty();
    }

    @PostMapping("/lagrePerson")
    public void lagrePerson (Person innPerson) {prep.saveHashed(innPerson);}

    @GetMapping("/sjekkPerson")
    public boolean sjekkPerson (@PathVariable String username, @PathVariable String password){
        return prep.checkPassword(username, password);
    }


}
