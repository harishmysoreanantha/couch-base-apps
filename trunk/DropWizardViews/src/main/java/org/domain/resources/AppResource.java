package org.domain.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/app")
public class AppResource {

	@GET
	@Path("/view")
	public AppView getAppView() {
		return new AppView();
	}
}
