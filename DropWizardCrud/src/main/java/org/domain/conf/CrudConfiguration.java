package org.domain.conf;

import javax.sql.DataSource;

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

//	private static DataSource DATA_SOURCE = null;
//
//	public static DataSource getDATA_SOURCE() {
//		if (DATA_SOURCE == null) {
//            return getDefaultDataSource();
//        }
//
//        return DATA_SOURCE;
//    }
//	}
//
//	public static void setDATA_SOURCE(DataSource dATA_SOURCE) {
//		DATA_SOURCE = dATA_SOURCE;
//	}

	
//	private static DataSource getDefaultDataSource() {
//        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
//
//       
//        dataSource.setUser("topdog");
//        dataSource.setPassword("s3cret");
//        dataSource.setServerName("localhost");
//        dataSource.setPort(3306);
//        dataSource.setDatabaseName("pdkpl");
//
//        return dataSource;
//    }
}
