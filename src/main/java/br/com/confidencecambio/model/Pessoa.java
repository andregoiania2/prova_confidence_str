package br.com.confidencecambio.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Pessoa {
	@NotEmpty(message = "O campo nome não pode ser vazio ou Branco")
	private String nome;
}
