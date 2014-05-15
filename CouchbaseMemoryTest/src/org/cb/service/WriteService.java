/**
 * 
 */
package org.cb.service;

import org.apache.log4j.Logger;
import org.cb.utils.CouchbaseUtil;

import com.couchbase.client.CouchbaseClient;

/**
 * @author asudar
 * 
 */
public class WriteService implements Runnable {

	private static final Logger LOG = Logger.getLogger(WriteService.class);

	public void run() {
//
//		LOG.debug("Write Process Started at : " + new java.util.Date() + "\n\n");
//		long startTime = System.currentTimeMillis();
//
		writeDocuments();
//
//		long endTime = System.currentTimeMillis();
//
//		long elapsedTime = endTime - startTime;
//
//		LOG.debug("Write Process Ended at : " + new java.util.Date() + "\n\n");
//
//		LOG.debug("Total Time Elapse for Writing " + elapsedTime + " Seconds");
//
//		LOG.debug("\n\n");

	}

	public void writeDocuments() {
		CouchbaseClient client = CouchbaseUtil.getClient();
		System.out.println(client.hashCode());
		
		
//		Gson gson = new Gson();
//		byte[] addressBytes = null;
//		InputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream(new File("sample.txt"));
//			addressBytes = new byte[inputStream.available()];
//			inputStream.read(addressBytes);
//		} catch (FileNotFoundException e) {
//			LOG.warn("WriteService", e);
//		} catch (IOException e) {
//			LOG.warn("WriteService", e);
//		} finally {
//			if (inputStream != null) {
//				try {
//					inputStream.close();
//				} catch (IOException e) {
//					LOG.warn("WriteService", e);
//				}
//			}
//		}
//
//		String address = new String(addressBytes);
//
//		for (int i = 1; i <= 1000000; i++) {
//
//			User user = new User("user", i, "firstName", "lastName", "gender",
//					address, "email");
//
//			client.set(String.valueOf(user.getId()), gson.toJson(user));
//			// LOG.debug("User " + i + " is Written ");
		
//		}

		// CouchbaseUtil.closeClient();

	}

}
