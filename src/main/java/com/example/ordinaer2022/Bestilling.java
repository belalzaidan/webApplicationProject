package com.example.ordinaer2022;

import jakarta.persistence.*;

@Entity
@Table(name = "bestillinger")
public class Bestilling {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "navn")
    private String navn;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "epost")
    private String epost;

    @Column(name = "bord")
    private int bord;

    @Column(name = "vare")
    private String vare;

    public Bestilling(String navn, String telefon, String epost, int bord, String vare){
        this.id = id;
        this.navn= navn;
        this.telefon = telefon;
        this.epost = epost;
        this.bord = bord;
        this.vare = vare;
    }

    public Bestilling(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public int getBord() {
        return bord;
    }

    public void setBord(int bord) {
        this.bord = bord;
    }

    public String getVare() {
        return vare;
    }

    public void setVare(String vare) {
        this.vare = vare;
    }
}


