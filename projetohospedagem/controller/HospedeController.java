package com.projetohospedagem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetohospedagem.entities.Hospede;
import com.projetohospedagem.services.HospedeService;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

	private final HospedeService hospedeService;

	@Autowired
	public HospedeController(HospedeService hospedeService) {
		this.hospedeService = hospedeService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hospede> buscaHospedeControlId(@PathVariable Long id) {
		Hospede hospede = hospedeService.getHospedeById(id);
		if (hospede != null) {
			return ResponseEntity.ok(hospede);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Hospede>> buscaTodosHospedesControl() {
		List<Hospede> hospedes = hospedeService.getAllHospedes();
		return ResponseEntity.ok(hospedes);
	}

	@PostMapping("/")
	public ResponseEntity<Hospede> saveHospedesControl(@RequestBody Hospede Hospede) {
		Hospede saveHospede = hospedeService.saveHospede(Hospede);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveHospede);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Hospede> alteraHospedeControl(@PathVariable Long id, @RequestBody Hospede hospede) {
		Hospede alteraHospede = hospedeService.changeHospede(id, hospede);

		if (alteraHospede != null) {
			return ResponseEntity.ok(hospede);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHospedeControl(@PathVariable Long id) {
		boolean delete = hospedeService.deleteHospede(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}

