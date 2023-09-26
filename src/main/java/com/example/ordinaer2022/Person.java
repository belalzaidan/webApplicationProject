package com.example.ordinaer2022;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "Date of Birth")
    private LocalDate Date;


    public Person( String username, String password, LocalDate Date) {
        this.id = id;
        this.Date = Date;
        this.username = username;
        this.password = password;
    }

    public Person(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

//    public int calculatedate(){
//        LocalDate currentdate = LocalDate.now();
//        Period period =   Period.between(Date,currentdate);
//
//
//
//    }
}
