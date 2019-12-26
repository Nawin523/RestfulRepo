package com.rngs.restful.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rngs.restful.resource.model.GenericResponse;
import com.rngs.restful.resource.model.Person;
import com.rngs.restful.resource.service.PersonService;

@Path("/persons")
public class Restfacad {
	
	PersonService ps = new PersonService();
	
	@GET
	@Path("/getAllPersons")
	public Response getAllPersons() throws JsonProcessingException {
		 
		List<Person> persons = ps.getAllPeresons();
		GenericResponse gr = new GenericResponse();
		ObjectMapper objm = new ObjectMapper();
		if(null == persons) {
			gr.setStatus("404");
			gr.setMessage("App dont contains the users");
		objm.writeValueAsString(gr);
		return Response.status(404).entity(objm).build();
		}
		gr.setStatus("200");
		gr.setMessage("List of uses in the application is :");
		objm.writeValueAsString(gr);
		objm.writeValueAsString(persons);
		return Response.status(200).entity(objm).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addPerson")
	public String addPerson(Person p) {
		return ps.addPerson(p);
	}

}
