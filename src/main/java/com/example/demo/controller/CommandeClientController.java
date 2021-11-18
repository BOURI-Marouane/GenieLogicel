package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.CommandeClientRepository;

@Controller
public class CommandeClientController {

	
	@Autowired
	CommandeClientRepository commandeClientRepository;
}
