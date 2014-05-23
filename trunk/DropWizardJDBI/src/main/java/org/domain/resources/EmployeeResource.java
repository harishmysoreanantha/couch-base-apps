package org.domain.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.domain.dao.EmployeeDao;
import org.domain.model.Employee;

import com.sun.jersey.api.view.Viewable;
import com.yammer.metrics.annotation.Timed;

@Path("/employee")
public class EmployeeResource {

	private EmployeeDao employeeDao;

	public EmployeeResource(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	
	

	@GET
	@Path("/createTable")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String createEmployeeTable() {
		employeeDao.createEmployeeTable();
		return "Employee Table Created";
	}

	@GET
	@Path("/create")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String createEmployees() {

		Employee employee = new Employee("emp", 111, "AAA", 100.00);
		Employee employee1 = new Employee("emp", 222, "BBB", 200.00);
		Employee employee2 = new Employee("emp", 333, "CCC", 300.00);
		Employee employee3 = new Employee("emp", 444, "DDD", 400.00);
		Employee employee4 = new Employee("emp", 555, "EEE", 500.00);

		employeeDao.insertEmployee(employee);
		employeeDao.insertEmployee(employee1);
		employeeDao.insertEmployee(employee2);
		employeeDao.insertEmployee(employee3);
		employeeDao.insertEmployee(employee4);

		return "Employees are Created";
	}

	@GET
	@Path("/list")
	@Timed
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Employee> listAll() {
		System.out.println(employeeDao.getAll());
		return employeeDao.getAll();
	}

	@GET
	@Path("/delete/{id}")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String deleteEmployee(@PathParam("id") Integer id) {

		if (employeeDao.findById(id) != null) {
			employeeDao.delete(id);
			return "Employee Deleted";
		}

		return "Employee Not Found";

	}

	@GET
	@Path("/find/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public String findById(@PathParam("id") Integer id) {
		System.out.println("The Id is : " + id);
		Employee employee = employeeDao.findById(id);

		return (employee != null) ? "Employee Found : " + employee
				: "Employee Not Found !";

	}
	// //
	// // @GET
	// // @Path("/rank/{id}")
	// // @Produces(value = MediaType.APPLICATION_JSON)
	// // public String findRank(@PathParam("id") int id) {
	// //
	// // EmployeeDao dao = new EmployeeDao();
	// //
	// // return dao.findRank(id);
	// // }
	// //
	// // @GET
	// // @Path("/salsum")
	// // @Produces(value = MediaType.APPLICATION_JSON)
	// // public String getSumOfSalaries() {
	// //
	// // EmployeeDao employeeDao = new EmployeeDao();
	// //
	// // return "The Sum of All Salaries of Employees : "
	// // + employeeDao.getSumOfSalaries();
	// // }
	//
}
