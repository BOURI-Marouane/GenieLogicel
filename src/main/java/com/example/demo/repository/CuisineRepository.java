package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.CategoriesCuisine;


public interface CuisineRepository extends JpaRepository<CategoriesCuisine,Long> {
	
	public Page<CategoriesCuisine> findByDesignationContains(String mc,Pageable pageable);

}
