package org.domain.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.domain.dao.EmployeeDao;
import org.domain.model.Employee;

@Path("/employee")
public class EmployeeResource {

	@GET
	@Path("/create")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String createEmployees() {

		Employee employee = new Employee("emp", 666, "fff", 100);
		Employee employee1 = new Employee("emp", 777, "ggg", 200);
		Employee employee2 = new Employee("emp", 888, "hhh", 300);
		Employee employee3 = new Employee("emp", 999, "iii", 400);
		Employee employee4 = new Employee("emp", 1010, "jjj", 500);

		EmployeeDao dao = new EmployeeDao();
		dao.create(employee);
		dao.create(employee1);
		dao.create(employee2);
		dao.create(employee3);
		dao.create(employee4);

		return "Employees are Created";
	}

	@GET
	@Path("/list")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Employee> listAll() {
		EmployeeDao dao = new EmployeeDao();
		return dao.getAll();
	}

	@GET
	@Path("/delete/{id}")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String deleteEmployee(@PathParam("id") int id) {

		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.delete(id);

		return (employee != null) ? "Employee Deleted"
				: "Employee Not Available";
	}

	@GET
	@Path("/find/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public String findById(@PathParam("id") int id) {
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.findById(id);
		return (employee != null) ? "Employee Found : " + employee
				: "Employee Not Found";

	}

}
