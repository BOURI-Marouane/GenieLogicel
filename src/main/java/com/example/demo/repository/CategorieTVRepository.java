package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CategorieTV;


public interface CategorieTVRepository extends JpaRepository<CategorieTV,Long> {
	
	public Page<CategorieTV> findByDesignationContains(String mc,Pageable pageable);


}
