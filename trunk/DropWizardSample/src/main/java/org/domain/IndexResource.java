/**
 * 
 */
package org.domain;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yammer.metrics.annotation.Timed;

/**
 * @author asudar
 * 
 */
@Path("/dws")
public class IndexResource {

	@GET
	@Path("/list")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Timed
	public List<Sample> index() {
		Sample sample = new Sample();
		sample.setMessage("Welcome DropWizard !");

		Sample sample1 = new Sample();
		sample1.setMessage("Welcome DropWizard1 !");

		Sample sample2 = new Sample();
		sample2.setMessage("Welcome DropWizard2 !");

		List<Sample> sampleList = new ArrayList<Sample>();
		sampleList.add(sample);
		sampleList.add(sample1);
		sampleList.add(sample2);

		return sampleList;
	}

	@GET
	@Path("/welcome")
	@Produces(value = MediaType.TEXT_PLAIN)
	@Timed
	public String showWelcome() {
		return "Welcome to DropWizard";
	}

}
