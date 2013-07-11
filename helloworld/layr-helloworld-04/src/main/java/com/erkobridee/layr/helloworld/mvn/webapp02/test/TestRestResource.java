package com.erkobridee.layr.helloworld.mvn.webapp02.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class TestRestResource {

	@GET public String hello() {
		return "Hello World!";
	}
	
}