package org.cb.elastic.tests;

import org.cb.elastic.dw.conf.CouchbaseElasticConfiguration;
import org.cb.elastic.dw.resource.ElasticResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * @author asudar
 * 
 */
public class App extends Service<CouchbaseElasticConfiguration> {
	public static void main(String[] args) {
		try {
			new App().run(new String[] { "server" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(Bootstrap<CouchbaseElasticConfiguration> bootStrap) {
		bootStrap.setName("elastic-couchbase");
	}

	@Override
	public void run(CouchbaseElasticConfiguration configuration,
			Environment environment) throws Exception {

		environment.addResource(new ElasticResource());
	}
}
