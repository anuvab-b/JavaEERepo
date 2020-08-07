package org.anuvab.java.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.anuvab.java.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client client = ClientBuilder.newClient();
		
		//Good practice
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs6/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		//messagesTarget.path("2"); Cumbersome
		
		//Fluent API
		Message message = singleMessageTarget
				.resolveTemplate("messageId","2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);//returns an instance of whatever is mentioned in parenthesis.Use string to get pay-load directly, which is easier to handle and gives actual pay-load.
		/*
		 * Builder builder = webTarget.request(); 
		 * Response response = builder.get();
		 * 
		 */
		//Message message = response.readEntity(Message.class);
		
		Message message1 = singleMessageTarget
				.resolveTemplate("messageId","1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		//System.out.println(message1.getMessage());
		//System.out.println(message.getMessage());
		
		Message newMessage = new Message(4,"My new message from JAX-RS client","Anuvab");
		Response postResponse = messagesTarget
					.request()
					.post(Entity.json(newMessage));//Converting Java instance into JSON.
		System.out.println(postResponse);
		
		if(postResponse.getStatus()!=201) {
			System.out.println("Error occured");
		}
		//postResponse object has attributes for getting extra information.
		Message createdMessage = postResponse.readEntity(Message.class);//readEntity unwraps the response object.
		System.out.println(createdMessage.getMessage());
	}

}
