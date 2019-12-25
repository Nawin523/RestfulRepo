package com.rngs.restful.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.rngs.restful.resource.model.Person;
import com.rngs.restful.resource.service.PersonService;

@Path("/persons")
public class Restfacad {
	
	PersonService ps = new PersonService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllPersons")
	public String getAllPersons() throws JsonProcessingException {
		List<Person> persons = ps.getAllPeresons();
		//Gson json = new Gson(); 
		ObjectMapper objm = new ObjectMapper();
		
		return objm.writeValueAsString(persons);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addPerson")
	public String addPerson(Person p) {
		return ps.addPerson(p);
	}

}
