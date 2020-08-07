package org.anuvab.java.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//New instance of class created when a API request is made.
//Hence make it a Singleton where this one instance is held on.
@Singleton
@Path("test")
public class MyResource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		
		count = count + 1;
		
		return "It finally works" + count + " time(s)";
	}
	
	
	
}
