package com.projetohospedagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetohospedagem.entities.FuncionarioEntity;
import com.projetohospedagem.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    
    public List<FuncionarioEntity> buacaTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }
    
    public FuncionarioEntity buscaFuncionarioPeloCodigo(Long codigo) {
    	Optional <FuncionarioEntity> funcionario = funcionarioRepository.findById(codigo);
        return funcionario.orElse(null);
    }

    public FuncionarioEntity salvaFuncionario(FuncionarioEntity funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    
    public FuncionarioEntity alterarFuncionario(Long codigo, FuncionarioEntity alterarFuncionario) {
    	Optional <FuncionarioEntity> existeFuncionario = funcionarioRepository.findById(codigo);
    	if(existeFuncionario.isPresent()) {
    		alterarFuncionario.setCodigo(codigo);
    		return funcionarioRepository.save(alterarFuncionario);
    	} 
    	return null;
    }
    
    public boolean apagarFuncionario(Long codigo) {
    	Optional <FuncionarioEntity> existeFuncionario = funcionarioRepository.findById(codigo);
    	if(existeFuncionario.isPresent()) {
    		funcionarioRepository.deleteById(codigo);
    		return true;
    	} 
    	return false;
    }
}
	

