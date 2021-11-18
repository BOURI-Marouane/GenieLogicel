package com.example.demo.model;

public class ArticlePanier {

	  private CategorieAparielElectronique CategorieAE;
	  private CategorieAliments categorieAliment;
	  private int quantite;
	  
	  
	
	public CategorieAliments getCategorieAliment() {
		return categorieAliment;
	}
	public void setCategorieAliment(CategorieAliments categorieAliment) {
		this.categorieAliment = categorieAliment;
	}
	public CategorieAparielElectronique getCategorieAE() {
		return CategorieAE;
	}
	public void setCategorieAE(CategorieAparielElectronique categorieAE) {
		CategorieAE = categorieAE;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public ArticlePanier(CategorieAparielElectronique CategorieAE , int quantite,CategorieAliments categorieAliment) {
	
		this.CategorieAE = CategorieAE;
		this.quantite = quantite;
		this.categorieAliment=categorieAliment;
	}
	public ArticlePanier() {
	
	}
	
	public void addItem(Produit produit,int quantite)
	{
		LigneCommandeClient lc = new LigneCommandeClient();
		lc.setPrix(produit.getPrix());
		
		
	}
	  
}
