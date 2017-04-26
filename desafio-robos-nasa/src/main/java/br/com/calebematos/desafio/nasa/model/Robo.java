package br.com.calebematos.desafio.nasa.model;

/**
 *
 * @author Lucas Calebe
 * 
 */
public class Robo {

	private int coordenadaX;
	private int coordenadaY;
	private Direcao direcao;

	public Robo() {
		coordenadaX = 0;
		coordenadaY = 0;
		direcao = Direcao.NORTE;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	@Override
	public String toString() {
		return "(" + coordenadaX + "," + coordenadaY + "," + direcao.getOrientacao() + ")";
	}

}
