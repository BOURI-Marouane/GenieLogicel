package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Client;
import com.example.demo.model.Produit;

public interface ClientRepository extends JpaRepository<Client, Long> {

	
	public Page<Client> findByNomeContains(String mc, Pageable pageable);
	
	public  List<Produit> findById(long id);

}