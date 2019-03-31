package com.java.webservice.jaxrs.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.java.webservice.jaxrs.beans.Person;

@Path("/hello")
public class MessageService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "From Server, Hello : " + msg;
 
		return Response.status(200).entity(output).build();
		
		
 
	}
	
	@GET
	@Path("/detail/{param}")
	@Produces("application/json")
	public Person getPerson(@PathParam("param") String name) {
 
		//String output = "From Server, Hello : " + msg;
        Person person=new Person();
        person.setName(name);
        person.setAge(20);
        Response.status(200).entity(person).build();
		return person;

	}
	
	@GET
	@Path("/getMsg")
	@Produces(MediaType.TEXT_HTML)  
	public String getMsg2(){
 
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"  
        + "<body><h1>" + "Hello Jersey HTML" + "</h1></body>" + "</html> ";  
		
		
 
	}
	
}
