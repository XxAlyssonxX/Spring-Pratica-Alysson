package com.projetohospedagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetohospedagem.entities.Hospede;
import com.projetohospedagem.repository.HospedeRepository;

@Service
public class HospedeService {
	private final HospedeRepository hospedeRepository;

	@Autowired
	public HospedeService(HospedeRepository hospedeRepository) {
		this.hospedeRepository = hospedeRepository;
	}

	public List<Hospede> getAllHospedes() {
		return hospedeRepository.findAll();
	}

	public Hospede getHospedeById(Long id) {
		Optional<Hospede> hospede = hospedeRepository.findById(id);
		return hospede.orElse(null);
	}

	public Hospede saveHospede(Hospede hospede) {
		return hospedeRepository.save(hospede);
	}

	public Hospede changeHospede(Long id, Hospede changeHosp) {
		Optional<Hospede> existeHospede = hospedeRepository.findById(id);
		if (existeHospede.isPresent()) {
			changeHosp.setId(id);
			return hospedeRepository.save(changeHosp);
		}
		return null;
	}

	public boolean deleteHospede(Long id) {
		Optional<Hospede> existeHospede = hospedeRepository.findById(id);
		if (existeHospede.isPresent()) {
			hospedeRepository.deleteById(id);
			return true;
		}
		return false;
	}

}