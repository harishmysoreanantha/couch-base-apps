/**
 * 
 */
package org.domain.dao;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.couchbase.client.CouchbaseClient;

/**
 * @author asudar
 * 
 */
public class CouchbaseUtil {

	private static CouchbaseClient CLIENT = createClient();
	private static final Logger LOG = Logger.getLogger(CouchbaseClient.class);

	/**
	 * SingleTon
	 */
	private CouchbaseUtil() {
	}

	private static CouchbaseClient createClient() {

		ArrayList<URI> nodes = new ArrayList<URI>();
		nodes.add(URI.create("http://127.0.0.1:8091/pools"));
		try {
			CLIENT = new CouchbaseClient(nodes, "default", "");
		} catch (IOException ex) {
			LOG.warn("CouchbaseUtil", ex);
		}
		return CLIENT;
	}

	public static void closeClient() {
		if (CLIENT != null) {
			CLIENT.shutdown(60, TimeUnit.SECONDS);
		}

		LOG.debug("================ Couchbase Client is Closed ==============");
	}

	public static CouchbaseClient getClient() {
		return CLIENT;
	}

}
