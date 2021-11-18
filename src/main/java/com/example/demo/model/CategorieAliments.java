package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class CategorieAliments implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAliments;
	@NotNull
	@Size(min = 5, max = 70)
	private String designation;
	private double prix;
	private int quantite;
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	private String image;
	private Date registrationDate;
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getIdAliments() {
		return idAliments;
	}

	public void setIdAliments(int id) {
		this.idAliments = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public CategorieAliments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieAliments(long idAliments, String designation, double prix, int quantite, String image) {
		super();
		this.idAliments = idAliments;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
	}					
				

}
