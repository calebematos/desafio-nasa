package br.com.calebematos.desafio.nasa.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucas Calebe
 */
public enum Direcao {

	NORTE("N", 0), SUL("S", 180), LESTE("E", 90), OESTE("W", 270);

	private final String orientacao;
	private final int valor;
	private static final Map<Integer, Direcao> direcaoMap = new HashMap<>();

	static {
		for (Direcao direcao : Direcao.values()) {
			direcaoMap.put(direcao.getValor(), direcao);
		}
	}

	Direcao(final String posicao, final int valor) {
		this.orientacao = posicao;
		this.valor = valor;
	}

	public String getOrientacao() {
		return orientacao;
	}

	public int getValor() {
		return valor;
	}

	public static Direcao getRotacaoDirecao(Direcao direcao, Rotacao rotacao) {
		Direcao novaDirecao;
		int value = direcao.getValor() + rotacao.getValor();
		if (value < NORTE.getValor()) {
			novaDirecao = OESTE;
		} else if (value > OESTE.getValor()) {
			novaDirecao = NORTE;
		} else {
			novaDirecao = direcaoMap.get(value);
		}
		return novaDirecao;
	}

}
