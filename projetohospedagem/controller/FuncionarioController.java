package com.projetohospedagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetohospedagem.entities.FuncionarioEntity;
import com.projetohospedagem.services.FuncionarioService;



@RestController
@RequestMapping("/funcionario")

public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<FuncionarioEntity> buscaFuncionarioControlId(@PathVariable Long codigo) {
        FuncionarioEntity funcionario = funcionarioService.buscaFuncionarioPeloCodigo(codigo);
        if(funcionario != null) {
        	return ResponseEntity.ok(funcionario);
        }
        else {
        	return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<FuncionarioEntity>> buscaTodosFuncionariosControl(){
    	List<FuncionarioEntity> funcionario = funcionarioService.buacaTodosFuncionarios();
    	return ResponseEntity.ok(funcionario);
    }
    
    @GetMapping("/")
    public ResponseEntity<FuncionarioEntity> salvaProdutosControl(@RequestBody FuncionarioEntity produto){
    	FuncionarioEntity salvaProduto = funcionarioService.salvaFuncionario(produto);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
    }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<FuncionarioEntity> alteraProdutoControl(@PathVariable Long codigo,@RequestBody FuncionarioEntity produto){
    	FuncionarioEntity alteraProduto = funcionarioService.alterarFuncionario(codigo, produto);
    	if(alteraProduto != null) {
    		return ResponseEntity.ok(produto);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagaProdutoControl(@PathVariable Long codigo){
    	boolean apagar = funcionarioService.apagarFuncionario(codigo);
    	if(apagar) {
    		return ResponseEntity.ok().body("O Funcionario foi excluido com sucesso");
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
}
