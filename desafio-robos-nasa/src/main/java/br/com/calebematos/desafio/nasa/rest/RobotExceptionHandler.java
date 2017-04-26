package br.com.calebematos.desafio.nasa.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.calebematos.desafio.nasa.exception.RoboBadRequestException;
import br.com.calebematos.desafio.nasa.model.MensagemErro;

/**
 *
 * @author Lucas Calebe
 */
@Provider
public class RobotExceptionHandler implements ExceptionMapper<RoboBadRequestException> {

	private static final String ERROR_CODE = "400";
	private static final String ERROR_BAD_REQUEST = "Bad Request";

	@Override
	public Response toResponse(final RoboBadRequestException exception) {

		MensagemErro defaultErrorMessage = new MensagemErro(ERROR_CODE, ERROR_BAD_REQUEST);
		return Response.status(Status.BAD_REQUEST).entity(defaultErrorMessage).type(MediaType.TEXT_PLAIN).build();
	}
}
