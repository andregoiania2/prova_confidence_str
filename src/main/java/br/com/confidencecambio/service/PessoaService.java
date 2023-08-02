package br.com.confidencecambio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import br.com.confidencecambio.dto.ResponseDTO;
import br.com.confidencecambio.dto.TipoPessoa;
import br.com.confidencecambio.error.handler.CustomException;
import br.com.confidencecambio.model.Pessoa;
import br.com.confidencecambio.model.impl.ClienteImpl;
import br.com.confidencecambio.model.impl.GerenteImpl;
import br.com.confidencecambio.model.impl.RoboImpl;

@Service
public class PessoaService {
	
	private Pessoa getInstanciaPessoa(String nome, TipoPessoa tipoPessoa) {
		Pessoa pessoa = null;		
		if (tipoPessoa.equals(TipoPessoa.CLIENTE)) {
			pessoa = new ClienteImpl(nome);
		}
		if (tipoPessoa.equals(TipoPessoa.GERENTE)) {
			pessoa = new GerenteImpl(nome);
		}
		if (tipoPessoa.equals(TipoPessoa.ROBO)) {
			pessoa = new RoboImpl(nome);
		}	
		
		return pessoa;		
	}
	
	public ResponseDTO geraResponse(String nome, TipoPessoa tipo) {
		Pessoa pessoa = getInstanciaPessoa(nome, tipo); 
		validar(pessoa);	
		String[] split = pessoa.getNome().split(" ");			
		return ResponseDTO.builder()
				.nomeCompleto(pessoa.getNome().toUpperCase())
				.primeiroNome(split[0])
				.nomeUltimo(getUltimoNome(split))
				.nomeAbreviado(getNomeAbreviado(split))
				.build();		
	}

	private String getUltimoNome(String[] split) {
		if (split.length > 1) {
			return split[0]+" "+split[split.length -1];
		}
		return split[0];
	}

	private void validar(Pessoa pessoa) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoa);
		List<String> lista = new ArrayList<>();
		
		for (ConstraintViolation<Pessoa> constraintViolation : violations) {
			lista.add(constraintViolation.getMessage());
		}
		
		if (pessoa.getNome().length() != pessoa.getNome().trim().length()) {
			lista.add("Não pode haver espaço em branco no inicio e no final do nome.");
		}
		if (!lista.isEmpty()) {	
			throw new CustomException(lista);
		}	
	}

	private String getNomeAbreviado(String[] split) {
		StringBuilder bld = new StringBuilder();
		bld.append(split[0]+" ");
		if (split.length > 2) {
		
			for (int i = 1; i < split.length-1; i++) {
				if (split[i].equalsIgnoreCase("DE") ||
						split[i].equalsIgnoreCase("DOS") ||
						split[i].equalsIgnoreCase("DA") ||
						split[i].equalsIgnoreCase("DI") ||
						split[i].equalsIgnoreCase("DU")						
						) {
					continue;
				}					
				bld.append(split[i].substring(0,1).toUpperCase() +". ");
			}
			bld.append(split[split.length-1]);
		}
		return bld.toString().trim();
	}

}
