package org.anuvab.java.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {
	
	public static void main(String[] args) {
		
		//Check querying messages by Year
		InvocationDemo demo = new InvocationDemo();
		Invocation invocation = demo.prepareRequestsForMessagesByYear(2015);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
		
	}
	
	public Invocation prepareRequestsForMessagesByYear(int year) {
		
        Client client = ClientBuilder.newClient();
		
		return client.target("http://localhost:8080/advanced-jaxrs6/webapi/")
									.path("messages")
									.queryParam("year", year)
									.request(MediaType.APPLICATION_JSON)
									.buildGet();
	};
	

}
