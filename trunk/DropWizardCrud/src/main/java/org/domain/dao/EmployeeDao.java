package org.domain.dao;

import java.util.ArrayList;
import java.util.List;

import net.spy.memcached.internal.OperationFuture;

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
		View view = client.getView("employees", "get_all");
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

	public boolean delete(int id) {

		OperationFuture<Boolean> operationFuture = client.delete(String
				.valueOf(id));
		return operationFuture.getStatus().isSuccess() ? true : false;

	}

	public Employee findById(int id) {
		Employee employee = null;
		Gson gson = new Gson();
		Object object = client.get(String.valueOf(id));

		return (object != null) ? employee = gson.fromJson(object.toString(),
				Employee.class) : employee;
	}

	public String findRank(int id) {
		Employee employee = null;
		Gson gson = new Gson();

		String empId = (String) client.get(String.valueOf(id));

		if (empId == null) {
			return "Employee Not Found !";
		}
		employee = gson.fromJson(empId, Employee.class);

		View view = client.getView("employees", "get_rank_by_salary");
		Query query = new Query();
		query.setIncludeDocs(true);
		query.setRangeStart(Double.toString(Double.MAX_VALUE));
		query.setRangeEnd(Double.toString(employee.getSalary()));
		query.setDescending(true);
		query.setReduce(true);

		ViewResponse viewResponse = client.query(view, query);

		String rank = null;
		for (ViewRow row : viewResponse) {
			rank = row.getValue();
		}

		return "Employee Rank Based on Salary : " + rank;
	}

	public String getSumOfSalaries() {

		String sumOfSalaries = null;
		View view = client.getView("employees", "get_sum_of_sal_of_employees");
		Query query = new Query();
		query.setIncludeDocs(true);

		ViewResponse response = client.query(view, query);

		for (ViewRow row : response) {
			sumOfSalaries = row.getValue();
		}

		return sumOfSalaries;
	}

}
