package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.example.demo.repository.ProduitRepository;

@SpringBootApplication
public class ProjetFinEtudeApplication {
    
	
	public static void main(String[] args) {
		  
		ApplicationContext ctx = SpringApplication.run(ProjetFinEtudeApplication.class, args);
		 ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		 
	}
	
	

}

