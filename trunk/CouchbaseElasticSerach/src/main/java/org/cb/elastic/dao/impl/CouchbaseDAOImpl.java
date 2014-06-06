/**
 * 
 */
package org.cb.elastic.dao.impl;

import org.cb.elastic.dao.CouchbaseDAO;
import org.cb.elastic.utils.CouchbaseUtil;

import com.couchbase.client.CouchbaseClient;

/**
 * @author asudar
 * 
 */
public class CouchbaseDAOImpl implements CouchbaseDAO {

	public Object findById(String id) {

		CouchbaseClient client = CouchbaseUtil.getClient();
		Object object = client.get(id);

		return object;
	}

}
