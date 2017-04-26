package br.com.calebematos.desafio.nasa.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.calebematos.desafio.nasa.business.AcoesRobo;
import br.com.calebematos.desafio.nasa.model.Robo;

/**
 *
 * @author Lucas Calebe
 * 
 */
@Path("/mars")
@Produces(APPLICATION_JSON)
public class RobotREST {

	@Inject
	private AcoesRobo acoesDoRobo;

	/**
	 * Recebe instrucoes para simular o comportamento do robo em marte
	 * 
	 * @param Comandos de movimento
	 * @return A posição final apos a instrução ou erro
	 */
	@POST
	@Path("{comandos}")
	public Response instructions(@PathParam("comandos") String comandos) {
		System.out.println("Comando recebido: " + comandos);

		Robo roboOutput = acoesDoRobo.agir(comandos);
		return Response.ok(roboOutput, MediaType.TEXT_PLAIN_TYPE).build();
	}

}
