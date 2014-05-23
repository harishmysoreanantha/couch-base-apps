package org.domain.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.domain.views.HomeView;

@Path("/home")
public class HomeResource {

	@GET	
	public HomeView getHomeView() {
		return new HomeView();
	}
	
}
