package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the klienci database table.
 * 
 */
@Entity
@Table(name="klienci")
@NamedQuery(name="Klienci.findAll", query="SELECT k FROM Klienci k")
public class Klienci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idklient;

	private String imie;

	private String nazwisko;

	private String pesel;

	private String telefon;

	public Klienci() {
	}

	public int getIdklient() {
		return this.idklient;
	}

	public void setIdklient(int idklient) {
		this.idklient = idklient;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}