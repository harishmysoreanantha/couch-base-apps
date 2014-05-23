package org.domain;

import org.domain.conf.AppConfiguration;
import org.domain.resources.AppResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

/**
 * Hello world!
 * 
 */
public class App extends Service<AppConfiguration> {
	public static void main(String[] args) throws Exception {

		new App().run(new String[] { "server" });
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootStarp) {
		bootStarp.setName("my-view");
		bootStarp.addBundle(new ViewBundle());
	}

	@Override
	public void run(AppConfiguration appConfiguration, Environment environment)
			throws Exception {

		environment.addResource(new AppResource());

	}
}
