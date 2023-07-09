package com.example.ordinaer2022;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApplicationController {

    // public List<Bestilling> bestillinger = new ArrayList<>();
    @Autowired
    ReservationRepo rep;

    @Autowired
    PersonRepo prep;

    @GetMapping("/checkStatus")
    public String checkStatus(){
        return "OK";
    }

    @RequestMapping(value = "{path:[^\\.]*}")
    public RedirectView redirect404() {
        return new RedirectView("/error/404");
    }

    @GetMapping("/error/404")
    public ResponseEntity<String> handle404Error() throws IOException {
        Resource resource = new ClassPathResource("static/404-error-page.html");
        String content = new String(Files.readAllBytes(resource.getFile().toPath()));
        return ResponseEntity.ok().body(content);
    }

    @PostMapping("/save")
    public void saveReservation (Reservation innReservation){
        rep.save(innReservation);
    }

    @GetMapping("/check")
    public ResponseEntity<Map<String, Boolean>> checkPhoneAndEmail
            (@RequestParam("phone") String phone, @RequestParam("email") String email) {
        List<Reservation> reservationsByPhone = rep.findByPhone(phone);
        List<Reservation> reservationsByEmail = rep.findByEmail(email);

        boolean phoneExists = !reservationsByPhone.isEmpty();
        boolean emailExists = !reservationsByEmail.isEmpty();

        Map<String, Boolean> result = new HashMap<>();
        result.put("phoneExists", phoneExists);
        result.put("emailExists", emailExists);

        return ResponseEntity.ok(result);
    }

    /*
    @PostMapping("/savePerson")
    public void savePerson (Person innPerson) {prep.saveHashed(innPerson);}

    @GetMapping("/sjekkPerson")
    public boolean sjekkPerson (@PathVariable String username, @PathVariable String password){
        return prep.checkPassword(username, password);
    }
    */

}
