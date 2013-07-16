package issue;

import static layr.api.ResponseBuilder.redirectTo;
import static layr.api.ResponseBuilder.template;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import layr.api.GET;
import layr.api.POST;
import layr.api.PathParameter;
import layr.api.QueryParameters;
import layr.api.Response;
import layr.api.WebResource;

@Stateless
@WebResource("issue")
public class IssueResource {

	@EJB private IssuePersistence persistence;
	
	@GET public Response list() {
		
		return template("issue/list.xhtml")
				.encoding("UTF-8")
				.set("issues", persistence.getAll());
		
	}
	
	@GET("new") public Response create() {
		return template("issue/edit.xhtml")
				.encoding("UTF-8")
				.set("postURL", "./insert")
				.set("submitLabel", "Create")
				.set("issue", new IssueModel());
	}
	
	@GET("{id}/edit") public Response edit(
		@PathParameter("id") Integer id
	) {
		return template("issue/edit.xhtml")
				.encoding("UTF-8")
				.set("postURL", "../update")
				.set("submitLabel", "Update")
				.set("issue", persistence.getById(id));
	}
	
	@POST("insert") public Response insert(
		@QueryParameters IssueModel issue
	) {
		System.out.println(issue);
		persistence.insert(issue);
		return redirectTo("../issue/");
	}
	
	@POST("update") public Response update(
		@QueryParameters IssueModel issue
	) {
		persistence.update(issue.getId(), issue);
		return redirectTo("../issue/");
	}
	
	@GET("{id}/remove") public Response remove(
		@PathParameter("id") Integer id
	) {
		persistence.remove(id);
		return redirectTo("../");
	}
	
}
