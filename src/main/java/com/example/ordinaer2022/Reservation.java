package com.example.ordinaer2022;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nameOfCustomer")
    private String nameOfCustomer;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "tableOfCustomer")
    private int tableOfCustomer;

    @Column(name = "item")
    private String item;

    public Reservation(String name, String phone, String email, int table, String item){
        this.id = id;
        this.nameOfCustomer= name;
        this.phone = phone;
        this.email = email;
        this.tableOfCustomer = table;
        this.item = item;
    }

    public Reservation(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nameOfCustomer;
    }

    public void setName(String name) {
        this.nameOfCustomer = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTable() {
        return tableOfCustomer;
    }

    public void setTable(int table) {
        this.tableOfCustomer = table;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}


