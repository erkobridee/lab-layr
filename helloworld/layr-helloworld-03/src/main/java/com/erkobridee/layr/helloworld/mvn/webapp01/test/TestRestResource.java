package com.erkobridee.layr.helloworld.mvn.webapp01.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class TestRestResource {

	@GET public String hello() {
		return "Hello World!";
	}
	
}