package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.CategorieVetements;

public interface VetementsRepository extends JpaRepository<CategorieVetements,Long>{
	
	public Page<CategorieVetements> findByDesignationContains(String mc,Pageable pageable);

}
