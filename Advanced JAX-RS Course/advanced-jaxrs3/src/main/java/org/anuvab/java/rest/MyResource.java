package org.anuvab.java.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// {pathParam} in Path annotation lets you map a resource to a variable path pattern.
@Path("test")
//NOTE : if initialized as Singleton, gets created before request is sent=> Error : path parameter cannot be injected into a singleton resource.
//Singleton resources are instantiated during application startup. So you cannot inject request-specific information to their variables.
public class MyResource {
	
	//If @Path("{{pathParam}test")
	//http://localhost:8080/advanced-jaxrs3/webapi/value/test?query=queryValue
	/*
	 * @PathParam("pathParam") private String pathParamExample;
	 * 
	 * @QueryParam("query") private String queryParamExample;
	 */
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String testMethod() { return
	 * "Path param used : " + pathParamExample +" Query param used : " +
	 * queryParamExample; }
	 */
	
	//Custom Media Type
	@GET
	@Produces("text/shortdate")
	public Date testMethod() {
		return Calendar.getInstance().getTime();
	}
	
	
	
}
