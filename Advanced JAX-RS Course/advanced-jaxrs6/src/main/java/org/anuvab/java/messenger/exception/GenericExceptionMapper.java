package org.anuvab.java.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

// This class intentionally doesn't have the @Provider annotation.
// It has been disabled in order to try out other ways of throwing exceptions in JAX-RS

// @Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		org.anuvab.java.messenger.model.ErrorMessage errorMessage = new org.anuvab.java.messenger.model.ErrorMessage(ex.getMessage(), 500, "http://javabrains.koushik.org");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

}