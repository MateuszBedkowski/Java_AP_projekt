package jpa_temp;

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
	private int idpracownik;

	private String imie;

	private String nazwisko;

	private String stanowisko;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	public Pracownicy() {
	}

	public int getIdpracownik() {
		return this.idpracownik;
	}

	public void setIdpracownik(int idpracownik) {
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}