/**
 * 
 */
package org.cb.service;

import org.apache.log4j.Logger;
import org.cb.utils.CouchbaseUtil;

import com.couchbase.client.CouchbaseClient;
import com.google.gson.Gson;

/**
 * @author asudar
 * 
 */
public class ReadService implements Runnable {

	private static final Logger LOG = Logger.getLogger(ReadService.class);

	public void run() {

//		try {
//			Thread.sleep(0);
//
//			LOG.debug("Read Process Started at : " + new java.util.Date()
//					+ "\n\n");
//			long startTime = System.currentTimeMillis();
			readDocuments();
//			long endTime = System.currentTimeMillis();
//
//			long elapsedTime = endTime - startTime;
//
//			LOG.debug("Read Process Ended at : " + new java.util.Date()
//					+ "\n\n");
//
//			LOG.debug("Total Time Elapse for Reading " + elapsedTime
//					+ " Seconds");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}

	public void readDocuments() {
		CouchbaseClient client = CouchbaseUtil.getClient();
		
		
		System.out.println("===="+client.hashCode());
//		Gson gson = new Gson();
//
//		for (int i = 1; i <= 1000000; i++) {
//
//			if (client.get(String.valueOf(i)) != null) {
//				client.delete(String.valueOf(i));
//				LOG.debug("Deleted");
//			}
//			LOG.debug("None");
//			//String gsonString = gson.toJson(client.get(String.valueOf(i)));
//			// User user = gson.fromJson(gsonString, User.class);
//			//LOG.debug(gsonString);
//		}

		CouchbaseUtil.closeClient();
	}
}
