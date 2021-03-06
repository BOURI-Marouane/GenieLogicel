package com.example.demo.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LigneCommandeClient;




public interface LigneCommandeRepository extends JpaRepository<LigneCommandeClient,Long> {
	
	public Page<LigneCommandeClient> findByIdLigneCdeCltContains(String mc,Pageable pageable);

}
