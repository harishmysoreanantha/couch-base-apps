/**
 * 
 */
package org.cb.elastic.dw.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.cb.elastic.dao.CouchbaseDAO;
import org.cb.elastic.dao.impl.CouchbaseDAOImpl;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author asudar
 * 
 */

@Path("/elastic")
public class ElasticResource {

	@Path("/search/{query}")
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Object> getSearchResults(@PathParam("query") String query) {

		List<Object> objects = new ArrayList<Object>();

		CouchbaseDAO couchbaseDAO = new CouchbaseDAOImpl();
		
		
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		WebResource resource = client.resource(getElasticURI(query));

		String[] ids = null;
		try {
			JSONObject jsonObject = new JSONObject(resource.accept(
					MediaType.APPLICATION_JSON).get(String.class));
			
			JSONObject hitsObj = jsonObject.getJSONObject("hits");
			
			System.out.println(hitsObj);
			JSONArray hitsArr = hitsObj.getJSONArray("hits");

			ids = new String[hitsArr.length()];
			
			for (int i = 0; i < hitsArr.length(); i++) {
				JSONObject obj = hitsArr.getJSONObject(i);
				JSONObject source = obj.getJSONObject("_source");

				JSONObject meta = source.getJSONObject("meta");
				ids[i] = meta.getString("id");

				Object object = couchbaseDAO.findById(ids[i]);
				objects.add(object);
			}

		} catch (UniformInterfaceException e) {
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return objects;

	}

	private static URI getElasticURI(String query) {
		return UriBuilder.fromUri(
				"http://localhost:9200/beer-sample/_search?q=" + query
						+ "&pretty=true").build();
	}
}
