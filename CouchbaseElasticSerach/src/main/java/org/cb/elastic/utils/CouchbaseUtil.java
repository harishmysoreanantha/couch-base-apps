/**
 * 
 */
package org.cb.elastic.utils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.couchbase.client.CouchbaseClient;

/**
 * @author asudar
 * 
 */
public class CouchbaseUtil {

	private static CouchbaseClient CLIENT = createClient();

	private CouchbaseUtil() {
	}

	private static CouchbaseClient createClient() {

		ArrayList<URI> nodes = new ArrayList<URI>();
		nodes.add(URI.create("http://127.0.0.1:8091/pools"));
		try {
			CLIENT = new CouchbaseClient(nodes, "beer-sample", "");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return CLIENT;
	}

	public static void closeClient() {
		if (CLIENT != null) {
			CLIENT.shutdown(60, TimeUnit.SECONDS);
		}

	}

	public static CouchbaseClient getClient() {
		return CLIENT;
	}
}
