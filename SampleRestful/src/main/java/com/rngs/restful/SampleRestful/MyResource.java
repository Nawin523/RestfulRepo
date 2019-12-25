package com.rngs.restful.SampleRestful;
 
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rngs.restful.resource.model.Person;
import com.rngs.restful.resource.service.PersonService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * 
     */
	PersonService ps = new PersonService();
	
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getIt() {
        return ps.getAllPeresons();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/strg")
    public String Meesaga() {
    	return "Naveen";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/msg")
    public List<Person> Meesagas() {
    	return ps.getAllPeresons();
    }
}
