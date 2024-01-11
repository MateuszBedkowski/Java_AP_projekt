package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the samochody database table.
 * 
 */

@Entity
@Table(name="samochody")
@NamedQuery(name="Samochody.findAll", query="SELECT s FROM Samochody s")
public class Samochody implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idsamochod;

	private String marka;

	private String moc;

	private String model;

	private String nadwozie;

	private String image;
	
	public Samochody() {
	}
	
	public Samochody(Samochody samochody) {
		getIdsamochod(samochody);
	}

	public int getIdsamochod(Samochody samochody) {
		return samochody.idsamochod;
	}
	
	public int getIdsamochod() {
		return this.idsamochod;
	}

	public void setIdsamochod(int idsamochod) {
		this.idsamochod = idsamochod;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getMoc() {
		return this.moc;
	}

	public void setMoc(String moc) {
		this.moc = moc;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNadwozie() {
		return this.nadwozie;
	}

	public void setNadwozie(String nadwozie) {
		this.nadwozie = nadwozie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}