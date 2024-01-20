package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pracownicy database table.
 * 
 */

@Entity
@Table(name="pracownicy")
@NamedQuery(name="Pracownicy.findAll", query="SELECT p FROM Pracownicy p")
public class Pracownicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpracownik;

	private String imie;

	private String nazwisko;

	private String stanowisko;
	
	private String login;
	
	private String haslo;
	
	//private Integer idrola;
	

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	public Pracownicy() {
	}

	public Integer getIdpracownik() {
		return this.idpracownik;
	}

	public void setIdpracownik(Integer idpracownik) {
		this.idpracownik = idpracownik;
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

	public String getStanowisko() {
		return this.stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
	
//	public Integer getRola() {
//		return this.idrola;
//	}
//	
//	public void setRola(Integer idrola) {
//		this.idrola = idrola;
//	}
	

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}


}