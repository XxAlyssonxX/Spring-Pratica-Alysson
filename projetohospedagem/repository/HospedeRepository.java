package com.projetohospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohospedagem.entities.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {

}
