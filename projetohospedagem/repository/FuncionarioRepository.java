package com.projetohospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohospedagem.entities.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository <FuncionarioEntity, Long>{

}
