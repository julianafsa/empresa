package br.com.dh.empresa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/boasvindas")
	public String ola() {
		return "Bem-vindo ao Spring Boot!"; 
	}

}
