package br.com.calebematos.desafio.nasa.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucas Calebe
 */
public enum Rotacao {
	LEFT('L', -90), RIGHT('R', 90);

	private final char rocacao;
	private final int valor;

	private static final Map<Character, Rotacao> rotacaoMap = new HashMap<>();

	static {
		for (Rotacao rotacao : Rotacao.values()) {
			rotacaoMap.put(rotacao.getRocacao(), rotacao);
		}
	}

	Rotacao(char rotationValue, int value) {
		this.valor = value;
		this.rocacao = rotationValue;
	}

	public char getRocacao() {
		return rocacao;
	}

	public int getValor() {
		return valor;
	}

	public static Rotacao getByValue(char rotacao) {
		return rotacaoMap.get(rotacao);
	}

}
