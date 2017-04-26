package br.com.calebematos.desafio.nasa.business;

import br.com.calebematos.desafio.nasa.model.Robo;

/**
 *
 * @author Lucas Calebe
 * 
 */
public interface AcoesRobo {

    public Robo agir(String instrucoes);  

    public boolean comandoValido(String instrucoes);

    public boolean comandoMovimento(char instrucoes);

    public boolean comandoRotacao(char instrucoes);

    public boolean movimentoValido(int novaCoordenadaX, int novaCoordenadaY);
    
}
