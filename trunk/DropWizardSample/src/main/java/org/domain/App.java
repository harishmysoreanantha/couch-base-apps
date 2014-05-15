package org.domain;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Hello world!
 * 
 */
public class App extends Service<DropWizardConfiguration> {
	public static void main(String[] args) {
		try {
			new App().run(new String[] { "server" });
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(Bootstrap<DropWizardConfiguration> bootstrap) {
		bootstrap.setName("DropWizard");
	}

	@Override
	public void run(DropWizardConfiguration configuration,
			Environment environment) throws Exception {
		environment.addResource(new IndexResource());

	}
}
