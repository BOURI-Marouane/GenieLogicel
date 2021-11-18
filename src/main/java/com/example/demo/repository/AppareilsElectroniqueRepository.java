package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CategorieAparielElectronique;


public interface AppareilsElectroniqueRepository extends JpaRepository<CategorieAparielElectronique,Long>{
	
	public Page<CategorieAparielElectronique> findByDesignationContains(String mc,Pageable pageable);

}
