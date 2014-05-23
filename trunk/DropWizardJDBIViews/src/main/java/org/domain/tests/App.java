package org.domain.tests;

import org.domain.conf.CrudConfiguration;
import org.domain.dao.EmployeeDao;
import org.domain.resources.CreateResource;
import org.domain.resources.EmployeeResource;
import org.domain.resources.HomeResource;
import org.skife.jdbi.v2.DBI;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

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
		bootStarp.addBundle(new ViewBundle());
		bootStarp.addBundle(new AssetsBundle("/META-INF/resources/webjars",
				"/webjars"));
	}

	@Override
	public void run(CrudConfiguration conf, Environment env) throws Exception {

		DBI dbi = new DBI(conf.getDataSource());
		EmployeeDao employeeDao = dbi.onDemand(EmployeeDao.class);

		env.addResource(new EmployeeResource(employeeDao));
		env.addResource(new HomeResource());
		env.addResource(new CreateResource());

	}
}
