package br.com.confidencecambio.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDTO {
	private String nomeCompleto;
	private String primeiroNome;
	private String nomeUltimo;
	private String nomeAbreviado;
}
