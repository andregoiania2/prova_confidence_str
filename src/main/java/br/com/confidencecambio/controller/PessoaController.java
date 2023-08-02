package br.com.confidencecambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.dto.ResponseDTO;
import br.com.confidencecambio.dto.TipoPessoa;
import br.com.confidencecambio.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	@Autowired
	private PessoaService service;
	
	@Operation(summary = "Devolve várias opções de nomes")	 
	@PostMapping	
	public ResponseDTO nomesPessoas(@RequestParam("nome") String nome,
			@RequestParam("tipoPessoa") TipoPessoa tipo) {		
		return service.geraResponse(nome, tipo);		
	}

}
