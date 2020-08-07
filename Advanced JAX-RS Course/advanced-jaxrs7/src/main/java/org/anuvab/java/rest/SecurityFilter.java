package org.anuvab.java.rest;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String SECURED_URI_PREFIX = "secured";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		
		if(requestContext.getUriInfo().getPath().contains(SECURED_URI_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			//Ideally List size should be 1
			if(authHeader!=null && authHeader.size()>0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,"");
				byte[] decodedString = Base64.getDecoder().decode(authToken);
				String finalDecodedString = new String(decodedString, "UTF-8");
				
				System.out.println("Decoded : "+ finalDecodedString);
				StringTokenizer tokenizer = new StringTokenizer(finalDecodedString,":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				//Next you can check in a DB or server if the username & password match.
				if("user".equals(username) && "password".equals(password)) {
					return;
				}
			}
				
				Response unauthorizedStatus = Response
													.status(Response.Status.UNAUTHORIZED)
													.entity("User cannot access the resource")
													.build();
				requestContext.abortWith(unauthorizedStatus);
		}
		
		
	}

}
