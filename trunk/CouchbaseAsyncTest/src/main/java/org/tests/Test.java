package org.tests;

import net.spy.memcached.internal.GetCompletionListener;
import net.spy.memcached.internal.GetFuture;

import org.utils.CouchbaseUtil;

import com.couchbase.client.CouchbaseClient;

public class Test {

	public static void main(String[] args) {

		CouchbaseClient client = CouchbaseUtil.getClient();
		
		

		client.asyncGet("111").addListener(new GetCompletionListener() {

			public void onComplete(GetFuture<?> future) throws Exception {

				Object ob = future.get();
				System.out.println(ob);

			}
		});

	}

}
