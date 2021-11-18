package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CategorieAliments;


public interface AlimentsRepository extends JpaRepository<CategorieAliments,Long> {
	public Page<CategorieAliments> findByDesignationContains(String mc,Pageable pageable);

}
