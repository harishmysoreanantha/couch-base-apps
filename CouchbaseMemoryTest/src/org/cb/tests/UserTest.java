/**
 * 
 */
package org.cb.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.cb.service.ReadService;
import org.cb.service.WriteService;

/**
 * @author asudar
 * 
 */
public class UserTest {

	/**
	 * @param args
	 */

	private static final Logger LOG = Logger.getLogger(UserTest.class);
	static {

		Properties properties = new Properties();
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(new File("log4j.properties"));
			properties.load(inputStream);

			PropertyConfigurator.configure(properties);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		// LOG.debug("=====================Process Started=========================");

		try {
//			Thread writeThread = new Thread(new WriteService());
//			writeThread.start();

			
			Thread readThread = new Thread(new ReadService());
			readThread.start();

			// CouchbaseUtil.closeClient();

		} catch (Exception exception) {
			LOG.warn("UserTest", exception);
		}

	}
}
