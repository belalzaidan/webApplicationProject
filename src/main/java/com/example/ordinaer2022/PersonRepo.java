package com.example.ordinaer2022;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository <Person,Long> {
    default Person saveHashed(Person newperson){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedpass = passwordEncoder.encode(newperson.getPassword());
        newperson.setPassword(hashedpass);
        return save(newperson);
    }
    default boolean checkPassword(String username, String password){
        Person person = findByUsername(username);
        if (person == null){
            return false;
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password,person.getPassword());

    }



    Person findByUsername(String username);
    List<Person> findByPassword(String password);



}
