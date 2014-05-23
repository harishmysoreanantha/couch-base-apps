package org.domain.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.domain.views.CreateView;

@Path("/create")
public class CreateResource {

	@GET
	public CreateView getCreateView() {

		return new CreateView();
	}

}
