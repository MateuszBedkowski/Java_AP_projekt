package com.jsf.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "wypozyczenie")
@NamedQuery(name = "Wypozyczenie.findAll", query = "SELECT w FROM Wypozyczenie w")
public class Wypozyczenie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idwypozyczenie", unique = true, nullable = false)
    private Integer idwypozyczenie;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "poczatek")
    private Date poczatek;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "koniec")
    private Date koniec;

    @Column(name = "kwota")
    private Double kwota;

    @ManyToOne
    @JoinColumn(name = "klienci_idklient", referencedColumnName = "idklient")
    private Klienci klienci;

    @ManyToOne
    @JoinColumn(name = "samochody_idsamochod", referencedColumnName = "idsamochod")
    private Samochody samochody;

    @ManyToOne
    @JoinColumn(name = "pracownicy_idpracownik", referencedColumnName = "idpracownik")
    private Pracownicy pracownicy;

    // Constructors, getters, setters...

    public Integer getIdwypozyczenie() {
        return idwypozyczenie;
    }

    public void setIdwypozyczenie(Integer idwypozyczenie) {
        this.idwypozyczenie = idwypozyczenie;
    }

    public Date getPoczatek() {
        return poczatek;
    }

    public void setPoczatek(Date poczatek) {
        this.poczatek = poczatek;
    }

    public Date getKoniec() {
        return koniec;
    }

    public void setKoniec(Date koniec) {
        this.koniec = koniec;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public Klienci getKlienci() {
        return klienci;
    }

    public void setKlienci(Klienci klienci) {
        this.klienci = klienci;
    }

    public Samochody getSamochody() {
        return samochody;
    }

    public void setSamochody(Samochody samochody) {
        this.samochody = samochody;
    }

    public Pracownicy getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Pracownicy pracownicy) {
        this.pracownicy = pracownicy;
    }
}
