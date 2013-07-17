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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("test")
public class TestJAXRSAdvanced {

	@Context private UriInfo uriInfo;
	
	@EJB private TestPersistence persistence;
	
	//--------------------------------------------------------------------------
	
	public static String toHexString(byte[] ba) {
	    StringBuilder str = new StringBuilder();
	    for(int i = 0; i < ba.length; i++)
	        str.append(String.format("%x", ba[i]));
	    return str.toString();
	}
	
	//--------------------------------------------------------------------------
	
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<TestModel> getAll() {
		return persistence.getAll();
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getById(
		@PathParam("id") Integer id
	) {
		
		
		TestModel value = persistence.getById(id);
		
		ResponseBuilder builder;
		
		if(value != null) {
			builder = Response.ok(value);			
		} else {
			builder = Response.status(Status.NOT_FOUND);
			builder.type(MediaType.TEXT_PLAIN);
			builder.entity("id : " + id + " | not found");
		}
		
		return builder.build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response insert(TestModel value) {
		value = persistence.insert(value);
		
		UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri());
	    uriBuilder.path("{index}");
	    
	    EntityTag etag = new EntityTag(toHexString(value.toString().getBytes()));
		
		return Response.created(uriBuilder.build( value.getId() )).
	            tag(etag).
	            entity(value).
	            type(MediaType.APPLICATION_JSON).
	            build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(
		@PathParam("id") Integer id,
		TestModel value
	) {
		persistence.update(id, value);
		
		ResponseBuilder builder = Response.status(Status.ACCEPTED);
		return builder.build();
	}
	
	@DELETE
	@Path("{id}")
	public Response remove(
		@PathParam("id") Integer id
	) {
		persistence.remove(id);
		
		ResponseBuilder builder = Response.status(Status.ACCEPTED);
		return builder.build();
	}
	
}
