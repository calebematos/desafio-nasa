package br.com.calebematos.desafio.nasa;

	
import org.junit.Test;

import br.com.calebematos.desafio.nasa.business.AcoesRoboMarte;
import br.com.calebematos.desafio.nasa.exception.RoboBadRequestException;
import br.com.calebematos.desafio.nasa.model.Robo;

/**
 *
 * @author Lucas Calebe
 * 
 */
public class RobotMarsOperatorTest {

    private AcoesRoboMarte operadorRoboMarte = new AcoesRoboMarte(new Robo());

    @Test
    public void operacoesCorretas() {
        operadorRoboMarte.agir("MMMM");
        operadorRoboMarte = new AcoesRoboMarte(new Robo());
        operadorRoboMarte.agir("MMRMMLM");
        operadorRoboMarte = new AcoesRoboMarte(new Robo());
        operadorRoboMarte.agir("MML");
    }

    @Test(expected = RoboBadRequestException.class)
    public void operacaoInvalidaComErro() {
        operadorRoboMarte.agir("QUALQUER");
        operadorRoboMarte.agir("MMMMMMMMMM");
        operadorRoboMarte.agir("LM");
    }


}
