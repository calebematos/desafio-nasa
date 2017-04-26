package br.com.calebematos.desafio.nasa.business;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.calebematos.desafio.nasa.exception.RoboBadRequestException;
import br.com.calebematos.desafio.nasa.model.Direcao;
import br.com.calebematos.desafio.nasa.model.Robo;
import br.com.calebematos.desafio.nasa.model.Rotacao;

/**
 *
 * @author Lucas Calebe
 * 
 */
@Named
public class AcoesRoboMarte implements AcoesRobo {

	private static final char COMANDO_MOVIMENTO = 'M';
	private static final int COORDENADA_MIN = 0;
	private static final int COORDENADA_MAX = 4;

	private final Robo robo;

	@Inject
	public AcoesRoboMarte(Robo robo) {
		this.robo = robo;
	}

	@Override
	public Robo agir(String comandos) {

		if (!comandoValido(comandos)) {
			throw new RoboBadRequestException();
		}

		for (char comando : comandos.toCharArray()) {

			if (comandoMovimento(comando)) {
				realizarMovimento();

			} else if (comandoRotacao(comando)) {
				Rotacao rotationEnum = Rotacao.getByValue(comando);
				realizarRotacao(rotationEnum);
			}
		}

		return robo;
	}

	@Override
	public boolean comandoValido(String comandos) {

		boolean instrucaoValida = false;

		String limitesDoMovimento = new String(new char[COORDENADA_MAX + 1]).replace("\0",
				String.valueOf(COMANDO_MOVIMENTO));

		if (!comandos.contains(limitesDoMovimento) && comandos.matches("^[LRM]*")) {
			instrucaoValida = true;
		}

		return instrucaoValida;

	}

	@Override
	public boolean comandoMovimento(char instrucoes) {
		return COMANDO_MOVIMENTO == instrucoes;

	}

	@Override
	public boolean comandoRotacao(char comandos) {
		return Rotacao.getByValue(comandos) != null;
	}

	private void realizarMovimento() {

		int novaCoordenadaX = robo.getCoordenadaX();
		int novaCoordenadaY = robo.getCoordenadaY();

		Direcao direcao = robo.getDirecao();
		switch (direcao) {
		case NORTE:
			novaCoordenadaY++;
			break;
		case SUL:
			novaCoordenadaY--;
			break;
		case LESTE:
			novaCoordenadaX++;
			break;
		case OESTE:
			novaCoordenadaX--;
			break;
		}

		if (movimentoValido(novaCoordenadaX, novaCoordenadaY)) {
			robo.setCoordenadaX(novaCoordenadaX);
			robo.setCoordenadaY(novaCoordenadaY);

			System.out.println("Posição atual do robô (" + robo.getCoordenadaX() + "," + robo.getCoordenadaY() + ","
					+ robo.getDirecao().getOrientacao() + ")");
		} else {
			System.err.println("ERRO. Robô na posição (" + novaCoordenadaX + "," + novaCoordenadaY + ","
					+ robo.getDirecao().getOrientacao() + ")");
			throw new RoboBadRequestException();
		}
	}

	@Override
	public boolean movimentoValido(int novaCoordenadaX, int novaCoordenadaY) {
		return novaCoordenadaX <= COORDENADA_MAX && novaCoordenadaX >= COORDENADA_MIN
				&& novaCoordenadaY >= COORDENADA_MIN && novaCoordenadaY <= COORDENADA_MAX;
	}

	private void realizarRotacao(Rotacao novaRotacao) {
		Direcao orientacao = robo.getDirecao();

		Direcao novaOrientacao = Direcao.getRotacaoDirecao(orientacao, novaRotacao);
		robo.setDirecao(novaOrientacao);

		System.out.println("Posição atual do robô: (" + robo.getCoordenadaX() + "," + robo.getCoordenadaY() + ","
				+ robo.getDirecao().getOrientacao() + ")");
	}

}
