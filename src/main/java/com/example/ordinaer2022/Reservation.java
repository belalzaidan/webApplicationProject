package com.example.ordinaer2022;

import jakarta.persistence.*;

@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name_Of_Customer")
    private String name_Of_Customer;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "table_Of_Customer")
    private int table_Of_Customer;


    @Column(name = "item")
    private String item;

    public Reservation(String name, String phone, String email, int table, String item){
        this.name_Of_Customer= name;
        this.phone = phone;
        this.email = email;
        this.table_Of_Customer = table;
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
        return name_Of_Customer;
    }

    public void setName(String name) {
        this.name_Of_Customer = name;
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
        return table_Of_Customer;
    }

    public void setTable(int table) {
        this.table_Of_Customer = table;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}


