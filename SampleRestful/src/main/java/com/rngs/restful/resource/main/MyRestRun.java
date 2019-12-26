package com.rngs.restful.resource.main;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class MyRestRun {
	
	private static final String webServiceURI = "http://localhost:8080/SampleRestful/webapi/";

	public static void main(String[] args) {
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		URI serviceUri = UriBuilder.fromUri(webServiceURI).build();
		WebTarget target = client.target(serviceUri);
		
		String response = target.path("myresource").path("strg").request()
				.accept(MediaType.TEXT_PLAIN).get(String.class).toString();
		
		String responseXml = target.path("myresource").request()
				.accept(MediaType.APPLICATION_XML).get(String.class).toString();
		
		String responseJson = target.path("myresource").path("appjson").request()
				.accept(MediaType.APPLICATION_JSON).get(String.class).toString();
		
		System.out.println(response); 
		System.out.println(responseXml);
		System.out.println(responseJson);
		
	}

}
