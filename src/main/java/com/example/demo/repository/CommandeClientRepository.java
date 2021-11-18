package com.example.demo.repository;



import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CommandeClient;



public interface CommandeClientRepository extends JpaRepository<CommandeClient,Long>{
    
	public Page<CommandeClient> findByIdCommandeClient(Long mc,Pageable pageable);
	
	
	
}
