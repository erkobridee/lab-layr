package test;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("test/basic")
public class TestJAXRSBasic {

	@EJB private TestPersistence persistence;
	
	
	@GET @Path("hello") public String hello() {
		return "Hello World!";
	}
	
	
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<TestModel> getAll() {
		return persistence.getAll();
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public TestModel getById(
		@PathParam("id") Integer id
	) {
		return persistence.getById(id);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void insert(TestModel value) {
		persistence.insert(value);
	}
	
	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(
		@PathParam("id") Integer id,
		TestModel value
	) {
		persistence.update(id, value);
	}
	
	@DELETE
	@Path("{id}")
	public void remove(
		@PathParam("id") Integer id
	) {
		persistence.remove(id);
	}
	
}
