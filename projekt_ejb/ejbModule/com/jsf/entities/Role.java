package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrola;

	private String nazwa;

	//bi-directional many-to-one association to Pracownicy
	@OneToMany(mappedBy="role")
	private List<Pracownicy> pracownicies;

	public Role() {
	}

	public int getIdrola() {
		return this.idrola;
	}

	public void setIdrola(int idrola) {
		this.idrola = idrola;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Pracownicy> getPracownicies() {
		return this.pracownicies;
	}

	public void setPracownicies(List<Pracownicy> pracownicies) {
		this.pracownicies = pracownicies;
	}

	public Pracownicy addPracownicy(Pracownicy pracownicy) {
		getPracownicies().add(pracownicy);
		pracownicy.setRole(this);

		return pracownicy;
	}

	public Pracownicy removePracownicy(Pracownicy pracownicy) {
		getPracownicies().remove(pracownicy);
		pracownicy.setRole(null);

		return pracownicy;
	}

}