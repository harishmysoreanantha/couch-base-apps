package org.domain.conf;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.yammer.dropwizard.config.Configuration;

public class CrudConfiguration extends Configuration {

	// @JsonProperty
	// @NotEmpty
	// public final String url = "http://127.0.0.1:8091/pools";
	//
	// @JsonProperty
	// @NotEmpty
	// public final String bucket = "default";
	//
	// @JsonProperty
	// public final String password = "";

	private DataSource dataSource = null;

	public DataSource getDataSource() {
		if (dataSource == null) {
			return getDefaultDataSource();
		}

		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private DataSource getDefaultDataSource() {
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();

		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("dropdb");

		return dataSource;
	}
}
