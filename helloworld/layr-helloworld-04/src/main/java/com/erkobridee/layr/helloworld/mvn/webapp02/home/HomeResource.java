package com.erkobridee.layr.helloworld.mvn.webapp02.home;

import static layr.api.ResponseBuilder.template;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import layr.api.GET;
import layr.api.QueryParameter;
import layr.api.Response;
import layr.api.WebResource;


@WebResource("home")
@Stateless
public class HomeResource {

	@EJB ProfileMeasurer profileMeasurer;

	@GET
	public Response chooseARandomHomeScreen(
		@QueryParameter("userName") String userName
	) {
				
		String templateName = ( profileMeasurer.measurer() == 0 )
							? "home/default.xhtml"
							: "home/alternative.xhtml";

		if ( userName == null )
			userName = "Guest";

		return template( templateName )  
				.set("userName", userName);
	}	
	
}