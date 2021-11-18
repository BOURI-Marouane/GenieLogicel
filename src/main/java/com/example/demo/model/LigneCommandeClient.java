package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandeClient {
	
	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY) 
	private Long idLigneCdeClt;
	
	private int quantite;
	
	private double prix;
	
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
	
	

	public LigneCommandeClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommandeClient(int quantite, CategorieAliments categorieAliments, CommandeClient commandeClient,double prix) {
		super();
		this.quantite = quantite;
		this.categorieAliments = categorieAliments;
		this.commandeClient = commandeClient;
		this.prix=prix;
	}

	public LigneCommandeClient(CommandeClient commandeClient,CategorieAliments categorieAliments) {
		super();
	    this.categorieAliments=categorieAliments;
		this.commandeClient = commandeClient;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUIT")
	private CategorieAliments categorieAliments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CommandeClient")
	private CommandeClient commandeClient;

	public Long getIdLigneCdeClt() {
		return idLigneCdeClt;
	}

	public void setIdLigneCdeClt(Long idLigneCdeClt) {
		this.idLigneCdeClt = idLigneCdeClt;
	}

	public CategorieAliments getCategorieAliments() {
		return categorieAliments;
	}

	public void setCategorieAliments(CategorieAliments categorieAliments) {
		this.categorieAliments = categorieAliments;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	
	
	
	
	

}
