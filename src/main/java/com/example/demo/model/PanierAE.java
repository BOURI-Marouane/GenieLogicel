package com.example.demo.model;

public class PanierAE {
	 
	 private CategorieAparielElectronique categorieAparielElectronique;
	 private int quantite;
	public CategorieAparielElectronique getCategorieAparielElectronique() {
		return categorieAparielElectronique;
	}
	public void setCategorieAparielElectronique(CategorieAparielElectronique categorieAparielElectronique) {
		this.categorieAparielElectronique = categorieAparielElectronique;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public PanierAE(CategorieAparielElectronique categorieAparielElectronique, int quantite) {
		super();
		this.categorieAparielElectronique = categorieAparielElectronique;
		this.quantite = quantite;
	}
	public PanierAE() {
		super();
	}
	

}
