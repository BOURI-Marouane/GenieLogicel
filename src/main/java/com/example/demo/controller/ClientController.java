package com.example.demo.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;


import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ArticlePanier;
import com.example.demo.model.CategorieAliments;
import com.example.demo.model.CategorieAparielElectronique;
import com.example.demo.model.CategorieTV;
import com.example.demo.model.CategorieVetements;
import com.example.demo.model.CategoriesCuisine;
import com.example.demo.model.CategoriesSports;
import com.example.demo.model.Client;
import com.example.demo.model.CommandeClient;
import com.example.demo.model.LigneCommandeClient;
import com.example.demo.model.Panier;

import com.example.demo.model.Produit;
import com.example.demo.repository.AlimentsRepository;
import com.example.demo.repository.AppareilsElectroniqueRepository;
import com.example.demo.repository.CategorieTVRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.CommandeClientRepository;
import com.example.demo.repository.CuisineRepository;
import com.example.demo.repository.LigneCommandeRepository;

import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.SportRepository;
import com.example.demo.repository.VetementsRepository;




@Controller
public class ClientController {
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	
	@Autowired
	CommandeClientRepository commandeClientRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private AlimentsRepository alimentsRepository;
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@Autowired
	private VetementsRepository vetementsRepository;
	
	@Autowired
	private CategorieTVRepository categorieTVRepository;
	
	@Autowired
	private SportRepository sportRepository;
	
	@Autowired
	private AppareilsElectroniqueRepository appareilsElectroniqueRepository;
	
	@GetMapping("/")
	public String chercher() {	
		return "index";
	}
	
	/*----------------------------------------------------------------------------------------------------------------*/
	@GetMapping("/homeAliments")
	public String homeAliment(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategorieAliments> pageProduits = alimentsRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsA", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "homeAliments";
	}
	
	/*----------------------------------------------------------------------------------------------------------------*/
	
	@GetMapping("/homeCuisine")
	public String homeCuisine(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategoriesCuisine> pageProduits = cuisineRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsCS", pageProduits.getContent());
		/*
		 * model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		 * model.addAttribute("currentPage", page); model.addAttribute("motCle", mc);
		 */
		return "homeCuisine";
	}
	
	/*----------------------------------------------------------------------------------------------------------------*/
	
	
	@GetMapping("/homeVetement")
	public String homeVetement(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategorieVetements> pageProduits = vetementsRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsV", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "homeVetement";
	}
	
	/*----------------------------------------------------------------------------------------------------------------*/
	
	
	@GetMapping("/homeTV")
	public String homeTV(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategorieTV> pageProduits = categorieTVRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsTV", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "homeTV";
	}
	
	/*----------------------------------------------------------------------------------------------------------------*/
	
	@GetMapping("/homeSport")
	public String homeSport(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategoriesSports> pageProduits = sportRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsSP", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "homeSport";
	}
	
	/*----------------------------------------------------------------------------------------------------------------*/
	
	@GetMapping("/homeAE")
	public String homeAE(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) 
	{
		Page<CategorieAparielElectronique> pageProduits = appareilsElectroniqueRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsAE", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "homeAE";
	}
	
	@GetMapping("/home")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Produit> pageProduits = produitRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduits", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "home";
	}
	
	
	
	List<ArticlePanier> panier = new ArrayList<ArticlePanier>();
    double total ;
	@PostMapping("/panier")
	public String panier(Model model,@Valid CategorieAparielElectronique cateApaElec,Long idAparielElect ,Long idAliments
			             ,@Valid CategorieAliments categorieAliment)
	{	 
		  total = 0;
		  int etat = 0;
	      //cateApaElec = appareilsElectroniqueRepository.findById(idAparielElect).get(); 		  
		  categorieAliment = alimentsRepository.findById(idAliments).get();	   		
			  for(ArticlePanier p : panier)
			  {		 
				  if(p.getCategorieAliment().getIdAliments() == idAliments)
				  {	
					      model.addAttribute("articlePanier1",panier);
					      p.setQuantite(p.getQuantite()+1);
					      total += p.getQuantite() * p.getCategorieAliment().getPrix() + p.getQuantite() * p.getCategorieAE().getPrix();	  					 
						  model.addAttribute("Total",total);
						  
						  etat = 1;
				  }
			  }
			  if(etat == 0)
			  {
				  panier.add(new ArticlePanier(cateApaElec, 1,categorieAliment));
				  for(ArticlePanier p : panier)
				  {
				  total += p.getQuantite() * p.getCategorieAliment().getPrix() + p.getQuantite() * p.getCategorieAE().getPrix();
				  }
				  model.addAttribute("articlePanier1",panier); 
				  model.addAttribute("Total",total); 
			  }		  	  		 
		return "/panier";
	 }

	@PostMapping("/savequantite")
	public String savequantite(Model model,@Valid CategorieAparielElectronique cateApaElec,Long idAparielElect ,Long idAliments,int quantite
            ,@Valid CategorieAliments categorieAliment)
				{	 
				total = 0;
				int etat = 0;
			
				//cateApaElec = appareilsElectroniqueRepository.findById(idAparielElect).get(); 		  
				categorieAliment = alimentsRepository.findById(idAliments).get(); 
				
				 for(ArticlePanier p : panier)
				 {	
					 
					  if(p.getCategorieAliment().getIdAliments() == idAliments)
					  {	
						      p.setQuantite(quantite);
						      model.addAttribute("articlePanier1",panier);					      
						      total += p.getQuantite() * p.getCategorieAliment().getPrix() + p.getQuantite() * p.getCategorieAE().getPrix();	  					 
							  model.addAttribute("Total",total);
							  
							  etat = 1;
					  }
				 }
				 if(etat == 0)
				 {
					  panier.add(new ArticlePanier(cateApaElec, 1,categorieAliment));
					  for(ArticlePanier p : panier)
					  {
					  total += p.getQuantite() * p.getCategorieAliment().getPrix() + p.getQuantite() * p.getCategorieAE().getPrix();
					  }
					  model.addAttribute("articlePanier1",panier); 
					  model.addAttribute("Total",total); 
				 }		  	  		 
				return "/panier";
				}

		
	
	
	
	@PostMapping("/panier1")
	public String panier1(Model model,@Valid CategorieAparielElectronique cateApaElec,Long idAparielElect 
			             ,@Valid CategorieAliments categorieAliment)
	{	 
		  total = 0;
	      cateApaElec = appareilsElectroniqueRepository.findById(idAparielElect).get(); 		  
		  		  
		  panier.add(new ArticlePanier(cateApaElec, 1,categorieAliment));	  
		  for(ArticlePanier p : panier)
		  {
			  total += p.getQuantite() * p.getCategorieAliment().getPrix() + p.getQuantite() * p.getCategorieAE().getPrix();
		  }	 	
		  model.addAttribute("Total",total);
		  model.addAttribute("articlePanier1",panier);
		  model.addAttribute("Pan",new Panier());		 
		  return "/panier";
	 }
	
	
	
	
			
		  @GetMapping("/panier")
		  public String panier(Model model )
		  {
		  model.addAttribute("Total",total);
		  model.addAttribute("articlePanier1",panier);
		  return "panier"; 
		  }
		  
		  @GetMapping("/panier1")
		  public String panier1(Model model )
		  {
		  model.addAttribute("Total",total);
		  model.addAttribute("articlePanier1",panier);
		  return "panier"; 
		  }	
			
	  @RequestMapping("/supprimerApEl")
	  public String Supprimer(Model model,Long id) {		
	  return "panier"; }
	 
	@PostMapping("/saveClient")
	public String saveClient(Model model,@Valid Client client,BindingResult bindingResult,
			                 @Valid CommandeClient commandeClt,@Valid LigneCommandeClient ligneCommandeClient)
	{	
		
		 int max = 400000;
		 int min = 500000;		 
		 int rand = (int) (Math.floor(Math.random() * (max - min + 1)) + min);
		 Date dateCommande = new Date();
		 
		 
		
		 client.setCode(rand);
		 
		 model.addAttribute("client",client);
		 model.addAttribute("commandeClt",new CommandeClient(client));
	    
		if(bindingResult.hasErrors()) return "FormClient";
		client.setRegistrationDate(dateCommande);
		clientRepository.save(client);
		commandeClt.setClient(client);
		commandeClt.setRegistrationDate(dateCommande);
		commandeClientRepository.save(commandeClt);
		
	    ligneCommandeClient.setCommandeClient(commandeClt);
		/* ligneCommandeClient.setCategorieAliments(categorieAliments); */   
	 
		  for(ArticlePanier p : panier) 
		  {		  
            ligneCommandeClient.setCategorieAliments(p.getCategorieAliment());
            ligneCommandeClient.setQuantite(p.getQuantite());
		  }
		  
		  ligneCommandeClient.getCategorieAliments().setQuantite(ligneCommandeClient.getCategorieAliments().getQuantite() - ligneCommandeClient.getQuantite());
		  alimentsRepository.save(ligneCommandeClient.getCategorieAliments());		 
		  
			ligneCommandeRepository.save(ligneCommandeClient);
			
			total=total*ligneCommandeClient.getQuantite();
			model.addAttribute("Total",total);
			model.addAttribute("ligneCommandeClient",ligneCommandeClient);
			model.addAttribute("articlePanier1",panier);
			panier = null; total = 0;
			return "Facturation";		
	}
	
	
	  
	@GetMapping("/saveClient")
	public String facturehome(Model model,@Valid Client client) {
     
		model.addAttribute("client",client);
		model.addAttribute("Total",total);
		return "Facturation";
	}
	
	

	

}
