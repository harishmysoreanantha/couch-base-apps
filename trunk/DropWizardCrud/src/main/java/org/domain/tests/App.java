package org.domain.tests;

import org.domain.conf.CrudConfiguration;
import org.domain.resources.EmployeeResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Hello world!
 * 
 */
public class App extends Service<CrudConfiguration> {
	public static void main(String[] args) {
		try {
			new App().run(new String[] { "server" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(Bootstrap<CrudConfiguration> bootStarp) {
		bootStarp.setName("DropWizard CRUD");
	}

	@Override
	public void run(CrudConfiguration conf, Environment env) throws Exception {
//		List<URI> nodes = new ArrayList<URI>();
//		nodes.add(URI.create(conf.url));
//		CouchbaseClient client = new CouchbaseClient(nodes, conf.bucket, conf.password); 
//		
		env.addResource(new EmployeeResource());

	}
}
