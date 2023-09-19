package com.projetohospedagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetohospedagem.entities.Aposento;
import com.projetohospedagem.services.AposentoService;

@RestController 

@RequestMapping("/aposento") 

public class AposentoController { 

	private final AposentoService aposentoService; 

	@Autowired 
	public AposentoController(AposentoService aposentoService) { 
		this.aposentoService = aposentoService; 
	} 

	@GetMapping("/{codigo}") 
	public ResponseEntity<Aposento> buscaAposentoControlId(@PathVariable Long codigo) { 
		Aposento aposento = aposentoService.buscaAposentoPeloCodigo(codigo); 
		if (aposento != null) { 
			return ResponseEntity.ok(aposento); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping 
	public ResponseEntity<List<Aposento>> buscaTodosAposentosControl() { 
		List<Aposento> aposentos = aposentoService.buscaTodosAposentos(); 
		return ResponseEntity.ok(aposentos); 
	} 

	@PostMapping("/") 
	public ResponseEntity<Aposento> salvaAposentoControl(@RequestBody Aposento aposento) { 
		Aposento salvaAposento = aposentoService.salvaAposento(aposento); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAposento); 
	} 

	@PutMapping("/{codigo}") 
	public ResponseEntity<Aposento> alteraAposentoControl(@PathVariable Long codigo, @RequestBody Aposento aposento) { 
		Aposento alteraAposento = aposentoService.alterarAposento(codigo, aposento); 
		if (alteraAposento != null) { 
			return ResponseEntity.ok(aposento); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@DeleteMapping("/{codigo}") 
	public ResponseEntity<String> apagaAposentoControl(@PathVariable Long codigo) { 
		boolean apagar = aposentoService.apagarAposento(codigo); 
		if (apagar) { 
			return ResponseEntity.ok().body("O Aposento foi excluído com sucesso"); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 


