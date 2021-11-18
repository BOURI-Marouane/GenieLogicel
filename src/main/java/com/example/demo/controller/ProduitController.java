
package com.example.demo.controller;

import java.io.File;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CategorieAliments;
import com.example.demo.model.CategorieAparielElectronique;
import com.example.demo.model.CategorieTV;
import com.example.demo.model.CategorieVetements;
import com.example.demo.model.CategoriesCuisine;
import com.example.demo.model.CategoriesSports;
import com.example.demo.model.Client;
import com.example.demo.model.Produit;
import com.example.demo.model.CommandeClient;
import com.example.demo.model.LigneCommandeClient;
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

public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CommandeClientRepository commandeClientRepository;
	
	@Autowired
	private LigneCommandeRepository lignecommandeRepository;
	
	@Autowired
	private CategorieTVRepository categorieTVRepository;
	
	@Autowired
	private AppareilsElectroniqueRepository appareilsElectroniqueRepository;
	
	@Autowired
	private VetementsRepository vetementsRepository;
	
	@Autowired
	private AlimentsRepository alimentsRepository;
	
	@Autowired
	private SportRepository sportRepository;
	
	@Autowired
	private CuisineRepository cuisineRepository;

	@GetMapping("/index")
	public String chercher(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<Produit> pageProduits = produitRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduits", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "produits";
	}
	
	/*------------------------------- PRODUIT TELEVISION -------------------------------------------------*/
	
	@GetMapping("/pagetv")
	public String ProduitTV(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategorieTV> pageProduits = categorieTVRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsTV", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "PageTV";
	}
	
	/*------------------------------- PRODUIT TELEVISION -------------------------------------------------*/
	/*------------------------------- PRODUIT APPAREILS ELECTRONIQUE -------------------------------------------------*/

	
	@GetMapping("/pageAE")
	public String ProduitApparElectronique(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategorieAparielElectronique> pageProduits = appareilsElectroniqueRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsAE", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "PageApparElectronique";
	}
	

	
	/*------------------------------- PRODUIT APPAREILS ELECTRONIQUE -------------------------------------------------*/
	/*------------------------------- PRODUIT VETEMENTS -------------------------------------------------*/
	
	@GetMapping("/pageV")
	public String ProduitVETEMENTS(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategorieVetements> pageProduits = vetementsRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsV", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "PageVetements";
	}
	
	
	/*------------------------------- PRODUIT VETEMENTS -------------------------------------------------*/
	/*------------------------------- PRODUIT Aliments -------------------------------------------------*/
	
	
	@GetMapping("/pageA")
	public String ProduitAliments(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "Cle", defaultValue = "") String mc) {

		Page<CategorieAliments> pageProduits = alimentsRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsA", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("Cle", mc);
		return "PageAliments";
	}
	
	
	/*------------------------------- PRODUIT Aliments -------------------------------------------------*/
	/*------------------------------- PRODUIT Sport -------------------------------------------------*/
	
	@GetMapping("/pageSP")
	public String ProduitSport(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategoriesSports> pageProduits = sportRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsSP", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "PageSport";
	}
	
	
	/*------------------------------- PRODUIT Sport -------------------------------------------------*/
	/*------------------------------- PRODUIT Cuisine -------------------------------------------------*/
	
	
	@GetMapping("/pageCS")
	public String ProduitCuisine(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		Page<CategoriesCuisine> pageProduits = cuisineRepository.findByDesignationContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listProduitsCS", pageProduits.getContent());
		model.addAttribute("page", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "PageCuisine";
	}
	
	/*------------------------------- PRODUIT Cuisine -------------------------------------------------*/

	@GetMapping("/Client")
	public String client(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		
		  Page<Client> pageClient = clientRepository.findByNomeContains(mc,
		  PageRequest.of(page, 5));
		  
		  model.addAttribute("listClient", pageClient.getContent());
		  model.addAttribute("pages", new int[pageClient.getTotalPages()]);
		  model.addAttribute("currentPage", page); model.addAttribute("motCle", mc);
		 
		return "Client";

	}

	@GetMapping("/CommandeClient")
	public String CommandeClient(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") Long mc) {
		
		 Page<CommandeClient> pageCommandeClient = commandeClientRepository.findAll(PageRequest.of(page, 5));
				  
		 model.addAttribute("listCommandeClient", pageCommandeClient.getContent());
	     model.addAttribute("pages", new int[pageCommandeClient.getTotalPages()]);
		 model.addAttribute("currentPage", page); 
		return "CommandeClient";
	}

	
	
	@GetMapping("/LigneCommandeClient")
	public String LigneCommandeClient(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") Long mc,Long id) {
		 Page<LigneCommandeClient> pageLigneCommandeClient = lignecommandeRepository.findAll(PageRequest.of(page, 5));
		 
		 model.addAttribute("listLigneCommandeClient", pageLigneCommandeClient.getContent());
	     model.addAttribute("pages", new int[pageLigneCommandeClient.getTotalPages()]);
		 model.addAttribute("currentPage", page); 
		return "LigneCommandeClient";
	}

	@GetMapping("/delete")
	public String delete(long id, int page, String motCle) {
		produitRepository.deleteById(id);
		return "redirect:/index?page=" + page + "&motCle=" + motCle;
	}
	
	/*------------------------------ Supprimer TV --------------------------------*/
	
	
	@GetMapping("/supprimer")
	public String supprimer(long id, int page, String motCle) {
		categorieTVRepository.deleteById(id);
		return "redirect:/pagetv?page=" + page + "&motCle=" + motCle;
	}
	
	
	/*------------------------------ Supprimer AE --------------------------------*/
	
	@GetMapping("/supprimerAE")
	public String supprimerAE(long id, int page, String motCle) {
		appareilsElectroniqueRepository.deleteById(id);
		return "redirect:/pageAE?page=" + page + "&motCle=" + motCle;
	}
	
	/*------------------------------ Supprimer V --------------------------------*/
	
	@GetMapping("/supprimerV")
	public String supprimerV(long id, int page, String motCle) {
		vetementsRepository.deleteById(id);
		return "redirect:/pageV?page=" + page + "&motCle=" + motCle;
	}
	
/*------------------------------ Supprimer AE --------------------------------*/
	
	@GetMapping("/supprimerAL")
	public String supprimerAL(long id, int page, String motCle) {
		alimentsRepository.deleteById(id);
		return "redirect:/pageAL?page=" + page + "&motCle=" + motCle;
	}
	
	/*------------------------------ Supprimer AE --------------------------------*/
	@GetMapping("/supprimerCS")
	public String supprimerCS(long id, int page, String motCle) {
		cuisineRepository.deleteById(id);
		return "redirect:/pageCS?page=" + page + "&motCle=" + motCle;
	}
/*------------------------------ Supprimer SP --------------------------------*/
	
	@GetMapping("/supprimerSP")
	public String supprimerSP(long id, int page, String motCle) {
		sportRepository.deleteById(id);
		return "redirect:/pageSP?page=" + page + "&motCle=" + motCle;
	}
	
	/*------------------------------ Supprimer SP --------------------------------*/
	
	@GetMapping("deleteClient")
	public String deleteClient(long id, int page, String motCle) {
		clientRepository.deleteById(id);
		return "redirect:/Client?page=" + page + "&motCle=" + motCle;
	}
	
	@GetMapping("deleteCommandeClient")
	public String deleteCommandeClient(long id, int page, String motCle) {
		commandeClientRepository.deleteById(id);
		return "redirect:/CommandeClient?page=" + page + "&motCle=" + motCle;
	}

	
	  @GetMapping("deleteLigneCommande") public String
	  deleteLigneCommandeClient(long id, int page, String motCle) {
	  lignecommandeRepository.deleteById(id); return
	  "redirect:/LigneCommandeClient?page=" + page + "&motCle=" + motCle; }
	 
	
	/*
	 * @GetMapping("/formProduit") public String form() { return "FormProduit"; }
	 */

	/*
	 * @GetMapping("/formProduit") public String form(Model model) {
	 * 
	 * model.addAttribute("produit",new Produit());
	 * 
	 * return "FormProduit"; }
	 */

	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		Produit produit = produitRepository.findById(id).get();
		model.addAttribute("produit", produit);

		return "redirect:/index";
	}
	
	/*------------------------------------------- Modifier TV -------------------------------------------------*/
	
	
	/*
	 * @GetMapping("/editTV") public String editTV(Model model, Long id) {
	 * CategorieTV produit = categorieTVRepository.findById(id).get();
	 * model.addAttribute("produit", produit);
	 * 
	 * return "redirect:/pagetv"; }
	 */
	
	
	
	/*------------------------------------------- Modifier TV -------------------------------------------------*/

	@GetMapping("/Deconnecter")
	public String login() {
		

		return "login";
	}
	
	@GetMapping("/Connecter")
	public String connecte() {
		

		return "login";
	}

	
	@PostMapping("/save")
	public String save(Model model, @Valid Produit produit, BindingResult bindingResult,
			@RequestParam(name = "pecture") MultipartFile file) throws Exception

	{

		
		if (bindingResult.hasErrors())
			return "FormProduit";

		if (!(file.isEmpty())) {
			System.out.println("------------------------------");
			System.out.println(file.getOriginalFilename());
			produit.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/photos/"
					+ file.getOriginalFilename()));
		}
		produitRepository.save(produit);
		return "redirect:/index";
	}
	
	
	
/*---------------------------------------------	Save TV	 ---------------------------------------------*/
	
	@PostMapping("/saveTV")
	public String saveTV(Model model, @Valid CategorieTV categorieTV, BindingResult bindingResult,
			@RequestParam(name = "pecture") MultipartFile file) throws Exception

	{

		Date DateProduitCuisine = new Date();
		if (bindingResult.hasErrors())
			return "FormProduit";

		if (!(file.isEmpty())) {
			System.out.println("------------------------------");
			System.out.println(file.getOriginalFilename());
			categorieTV.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/photos/"
					+ file.getOriginalFilename()));
		}
		
		categorieTV.setRegistrationDate(DateProduitCuisine);
		categorieTVRepository.save(categorieTV);
		return "redirect:/pagetv";
	}
	
	
/*---------------------------------------------	Save AE ---------------------------------------------*/
	
	@PostMapping("/saveAE")
	public String saveAE(Model model, @Valid CategorieAparielElectronique categorieTV, BindingResult bindingResult,
			@RequestParam(name = "pecture") MultipartFile file) throws Exception

	{

		Date DateProduitCuisine = new Date();
		if (bindingResult.hasErrors())
			return "FormProduit";

		if (!(file.isEmpty())) {
			System.out.println("------------------------------");
			System.out.println(file.getOriginalFilename());
			categorieTV.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/photos/"
					+ file.getOriginalFilename()));
		}
		categorieTV.setRegistrationDate(DateProduitCuisine);
		appareilsElectroniqueRepository.save(categorieTV);
		return "redirect:/pageAE";
	}
	
	
/*---------------------------------------------	Save AE	 ---------------------------------------------*/
/*---------------------------------------------	Save V	 ---------------------------------------------*/
	
	
	@PostMapping("/saveV")
	public String saveV(Model model, @Valid CategorieVetements categorieTV, BindingResult bindingResult,
			@RequestParam(name = "pecture") MultipartFile file) throws Exception

	{

		Date DateProduitCuisine = new Date();
		if (bindingResult.hasErrors())
			return "FormProduit";

		if (!(file.isEmpty())) {
			System.out.println("------------------------------");
			System.out.println(file.getOriginalFilename());
			categorieTV.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/photos1/"
					+ file.getOriginalFilename()));
		}
		
		categorieTV.setRegistrationDate(DateProduitCuisine);
		vetementsRepository.save(categorieTV);
		return "redirect:/pageV";
	}
	
	
	
/*---------------------------------------------	Save V	 ---------------------------------------------*/
/*---------------------------------------------	Save AL	 ---------------------------------------------*/
	
	@PostMapping("/saveAL")
	public String saveAL(Model model, @Valid CategorieAliments categorieTV, BindingResult bindingResult,Long idAliments,
			@RequestParam(name = "pecture") MultipartFile file) throws Exception

	{

		Date DateProduitCuisine = new Date();
		if (bindingResult.hasErrors())
			return "FormProduit";

		if (!(file.isEmpty())) {
			System.out.println("------------------------------");
			System.out.println(file.getOriginalFilename());
			categorieTV.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/photos1/"
					+ file.getOriginalFilename()));
		}
		categorieTV.setRegistrationDate(DateProduitCuisine);
		alimentsRepository.save(categorieTV);
		return "redirect:/pageA";
	}
	
/*---------------------------------------------	Save AL	 ---------------------------------------------*/
	
/*---------------------------------------------	Save SP	 ---------------------------------------------*/
	
	@PostMapping("/saveSP")
	public String saveSP(Model model, @Valid CategoriesSports categorieTV, BindingResult bindingResult,
			@RequestParam(name = "pecture") MultipartFile file) throws Exception

	{	
		Date DateProduitCuisine = new Date();
		if (bindingResult.hasErrors())
			return "FormProduit";
		if (!(file.isEmpty())) {
			System.out.println("------------------------------");
			System.out.println(file.getOriginalFilename());
			categorieTV.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/photos1/"
					+ file.getOriginalFilename()));
		}
		
		categorieTV.setRegistrationDate(DateProduitCuisine);
		sportRepository.save(categorieTV);
		return "redirect:/pageSP";
	}
	
/*---------------------------------------------	Save SP	 ---------------------------------------------*/
/*---------------------------------------------	Save CS	 ---------------------------------------------*/
	
	
	@PostMapping("/saveCS")
	public String saveCS(Model model, @Valid CategoriesCuisine categorieTV, BindingResult bindingResult,
			@RequestParam(name = "pecture") MultipartFile file) throws Exception

	{

		Date DateProduitCuisine = new Date();
		if (bindingResult.hasErrors())
			return "FormProduit";

		if (!(file.isEmpty())) {
			System.out.println("------------------------------");
			System.out.println(file.getOriginalFilename());
			categorieTV.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/photos2/"
					+ file.getOriginalFilename()));
		}
		categorieTV.setRegistrationDate(DateProduitCuisine);
		cuisineRepository.save(categorieTV);
		return "redirect:/pageCS";
	}
	
	
	
	
/*---------------------------------------------	Save CS	 ---------------------------------------------*/
	@GetMapping("/findOne")
	@ResponseBody
	public Optional<Produit> findOne(Long id) {
		return produitRepository.findById(id);
	}
/*---------------------------------------------	findTV TV ---------------------------------------------*/   
	@GetMapping("/findTV")
	@ResponseBody
	public Optional<CategorieTV> findTV(Long id) {
		return categorieTVRepository.findById(id);
	}
	
/*---------------------------------------------	findTV TV ---------------------------------------------*/
	
	/*---------------------------------------------	findTV TV ---------------------------------------------*/   
	@GetMapping("/findAE")
	@ResponseBody
	public Optional<CategorieAparielElectronique> findAE(Long id) {
		return appareilsElectroniqueRepository.findById(id);
	}
	
/*---------------------------------------------	findTV TV ---------------------------------------------*/
	/*---------------------------------------------	findTV V ---------------------------------------------*/
	
	@GetMapping("/findV")
	@ResponseBody
	public Optional<CategorieVetements> findV(Long id) {
		return vetementsRepository.findById(id);
	}
	
	/*---------------------------------------------	findTV V ---------------------------------------------*/
	/*---------------------------------------------	findTV AL ---------------------------------------------*/
	
	@GetMapping("/findAL")
	@ResponseBody
	public Optional<CategorieAliments> findAL(Long id) {
		return alimentsRepository.findById(id);
	}
	
	/*---------------------------------------------	findTV AL ---------------------------------------------*/
	/*---------------------------------------------	findTV AL ---------------------------------------------*/
	
	@GetMapping("/findSP")
	@ResponseBody
	public Optional<CategoriesSports> findSP(Long id) {
		return sportRepository.findById(id);
	}
	
	/*---------------------------------------------	findTV AL ---------------------------------------------*/
	/*---------------------------------------------	findTV CS ---------------------------------------------*/
	
	@GetMapping("/findCS")
	@ResponseBody
	public Optional<CategoriesCuisine> findCS(Long id) {
		return cuisineRepository.findById(id);
	}
	
	/*---------------------------------------------	findTV CS ---------------------------------------------*/
	/*---------------------------------------------	findAL Panier ---------------------------------------------*/
	
	
	
	@GetMapping("/findAll")
	@ResponseBody
	public Optional<CategoriesCuisine> findAll(Long id) {
		return cuisineRepository.findById(id);
	}
	
	
	
	/*---------------------------------------------	findAL Panier ---------------------------------------------*/
	
}
