package com.projetohospedagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetohospedagem.entities.Aposento;
import com.projetohospedagem.repository.AposentoRepository;

@Service 

public class AposentoService { 

	private final AposentoRepository aposentoRepository; 

	@Autowired 
	public AposentoService(AposentoRepository aposentoRepository) { 
		this.aposentoRepository = aposentoRepository; 
	} 

	public List<Aposento> buscaTodosAposentos() { 
		return aposentoRepository.findAll(); 
	} 

	public Aposento buscaAposentoPeloCodigo(Long codigo) { 
		Optional<Aposento> aposento = aposentoRepository.findById(codigo); 
		return aposento.orElse(null); 
	} 

	public Aposento salvaAposento(Aposento aposento) { 
		return aposentoRepository.save(aposento); 
	} 

	public Aposento alterarAposento(Long codigo, Aposento alterarAposento) { 
		Optional<Aposento> existeAposento = aposentoRepository.findById(codigo); 
		if (existeAposento.isPresent()) { 
			alterarAposento.setCodigo(codigo); 
			return aposentoRepository.save(alterarAposento); 
		} 
		return null; 
	} 


	public boolean apagarAposento(Long codigo) { 
		Optional<Aposento> existeAposento = aposentoRepository.findById(codigo); 
		if (existeAposento.isPresent()) { 
			aposentoRepository.deleteById(codigo); 
			return true; 
		} 
		return false; 
	} 

} 







