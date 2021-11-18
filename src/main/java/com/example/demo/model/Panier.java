package com.example.demo.model;


import java.util.*;

public class Panier  {
	
	private Map<Long,ArticlePanier> article= new HashMap<Long,ArticlePanier>();
	


     
    
	
	public void deleteItem(Long id)
	{
		article.remove(id);
	}
	
	public Collection<ArticlePanier> getArticle()
	{
		return article.values();
	}
	
	
	  public double getTotal()
	  { 
	      double total = 10; 
	      Collection<ArticlePanier>  items = getArticle();
	      for(ArticlePanier art : items)
	      { 
	    	  total += art.getQuantite()*art.getCategorieAE().getPrix();
	      } 
		  return total;
	  }
  
}
