package br.com.confidencecambio.error.handler;

import java.util.List;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CustomException(List<String> lista) {
		super(lista.toString());
	}
}
