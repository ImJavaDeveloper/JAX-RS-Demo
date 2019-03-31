package com.java.webservice.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientTest {  
	  public static void main(String[] args) {  
	  
		  //RESTful Java client with Jersey client
		  
		  Client client = Client.create();
		  WebResource webResource = client
				   .resource("http://localhost:8080/JAX-RS-Web/rest/hello/rahat");
		  ClientResponse response = webResource.accept("text/plain")
                  .get(ClientResponse.class);
		  
		  if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);
			
			//Below example is RESTful Java client with java.net.URL
			
			try {
				URL url = new URL("http://localhost:8080/JAX-RS-Web/rest/hello/detail/rahat");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

					String output1;
					System.out.println("Output from Server ....Client Using java.net.URL \n");
					while ((output1 = br.readLine()) != null) {
						
						System.out.println(output1);
					}

					conn.disconnect();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    //Now printing the server code of different media type  
	    /*System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class));  
	    System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class));  
	    System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class));  */
	  }  
	  private static URI getBaseURI() {  
	    //here server is running on 8080 port number and project name is JAX-RS-Web  
	    return UriBuilder.fromUri("http://localhost:8080/JAX-RS-Web").build();  
	  }  
	}
