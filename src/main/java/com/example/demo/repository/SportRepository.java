package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.CategoriesSports;

public interface SportRepository extends JpaRepository<CategoriesSports,Long> {
	public Page<CategoriesSports> findByDesignationContains(String mc,Pageable pageable);

}
