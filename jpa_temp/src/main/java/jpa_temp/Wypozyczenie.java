package jpa_temp;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wypozyczenie database table.
 * 
 */
@Entity
@Table(name="wypozyczenie")
@NamedQuery(name="Wypozyczenie.findAll", query="SELECT w FROM Wypozyczenie w")
public class Wypozyczenie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idwypozyczenie;

	@Column(name="klienci_idklient")
	private int klienciIdklient;

	@Temporal(TemporalType.DATE)
	private Date koniec;

	private String kwota;

	@Temporal(TemporalType.TIMESTAMP)
	private Date poczatek;

	@Column(name="pracownicy_idpracownik")
	private int pracownicyIdpracownik;

	@Column(name="samochody_idsamochod")
	private int samochodyIdsamochod;

	public Wypozyczenie() {
	}

	public int getIdwypozyczenie() {
		return this.idwypozyczenie;
	}

	public void setIdwypozyczenie(int idwypozyczenie) {
		this.idwypozyczenie = idwypozyczenie;
	}

	public int getKlienciIdklient() {
		return this.klienciIdklient;
	}

	public void setKlienciIdklient(int klienciIdklient) {
		this.klienciIdklient = klienciIdklient;
	}

	public Date getKoniec() {
		return this.koniec;
	}

	public void setKoniec(Date koniec) {
		this.koniec = koniec;
	}

	public String getKwota() {
		return this.kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public Date getPoczatek() {
		return this.poczatek;
	}

	public void setPoczatek(Date poczatek) {
		this.poczatek = poczatek;
	}

	public int getPracownicyIdpracownik() {
		return this.pracownicyIdpracownik;
	}

	public void setPracownicyIdpracownik(int pracownicyIdpracownik) {
		this.pracownicyIdpracownik = pracownicyIdpracownik;
	}

	public int getSamochodyIdsamochod() {
		return this.samochodyIdsamochod;
	}

	public void setSamochodyIdsamochod(int samochodyIdsamochod) {
		this.samochodyIdsamochod = samochodyIdsamochod;
	}

}