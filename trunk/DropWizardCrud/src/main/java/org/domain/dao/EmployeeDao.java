package org.domain.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.domain.model.Employee;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.google.gson.Gson;

public class EmployeeDao {

	private final CouchbaseClient client = CouchbaseUtil.getClient();

	public void create(Employee employee) {

		Gson gson = new Gson();
		client.set(String.valueOf(employee.getId()), gson.toJson(employee));

	}

	public List<Employee> getAll() {

		List<Employee> list = new ArrayList<Employee>();
		Gson gson = new Gson();
		View view = client.getView("", "");
		Query query = new Query();
		query.setIncludeDocs(true);

		ViewResponse response = client.query(view, query);
		for (ViewRow viewRow : response) {
			Employee employee = gson.fromJson(viewRow.getDocument().toString(),
					Employee.class);
			list.add(employee);
		}

		return list;
	}

	public Employee delete(int id) {
		return null;
	}

	public Employee findById(int id) {

		return null;
	}

}
