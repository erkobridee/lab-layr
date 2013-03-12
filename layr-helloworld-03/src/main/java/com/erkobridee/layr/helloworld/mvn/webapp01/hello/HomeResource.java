package com.erkobridee.layr.helloworld.mvn.webapp01.hello;

import javax.ejb.EJB;

import org.layr.jee.routing.business.Route;
import org.layr.jee.routing.business.WebResource;

@WebResource("/home/")
public class HomeResource {

	@EJB ProfileMeasurer profileMeasurer;
	
	String templateName;
	
	@Route(
		pattern="/",
		template="#{templateName}"
	)
	public void chooseARandomHomeScreen() {
		templateName = ( profileMeasurer.measurer() == 0 )
				? "home/default.xhtml"
				: "home/alternative.xhtml";
	}
	
}
