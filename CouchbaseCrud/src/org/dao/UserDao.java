package org.dao;

import java.util.ArrayList;
import java.util.List;

import net.spy.memcached.internal.OperationFuture;

import org.domain.Address;
import org.domain.User;
import org.util.CouchbaseUtil;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.google.gson.Gson;

public class UserDao {

	private final CouchbaseClient client = CouchbaseUtil.getClient();

	public void saveOrUpdate(User user) {
		Gson gson = new Gson();
		client.set("user" + user.getId(), 0, gson.toJson(user));
	}

	public User findById(int id) {
		User user = null;
		Gson gson = new Gson();
		Object object = client.get("user" + id);

		return (object != null) ? user = gson.fromJson(object.toString(),
				User.class) : user;

	}

	public boolean delete(int id) {
		OperationFuture<Boolean> operationFuture = client.delete("user" + id);
		return operationFuture.getStatus().isSuccess() ? true : false;

	}

	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		Gson gson = new Gson();

		View view = client.getView("users", "get_all");
		Query query = new Query();
		query.setIncludeDocs(true);
		ViewResponse viewResponse = client.query(view, query);

		for (ViewRow viewRow : viewResponse) {
			User user = gson.fromJson(viewRow.getDocument().toString(),
					User.class);
			users.add(user);
		}
		return users;
	}

	public List<Address> getAllAddresses() {
		List<Address> addressList = new ArrayList<Address>();
		Gson gson = new Gson();

		View view = client.getView("users", "get_all_addresses");
		Query query = new Query();
		query.setIncludeDocs(true);

		ViewResponse response = client.query(view, query);
		for (ViewRow viewRow : response) {

			// System.out.println(viewRow.getId()+"\t"+viewRow.getValue());
			Address address = gson.fromJson(viewRow.getValue().toString(),
					Address.class);
			addressList.add(address);
		}

		return addressList;

	}

	
}
