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

		Employee employee = new Employee("emp", 1011, "kkk", 600);
		Employee employee1 = new Employee("emp", 1012, "lll", 700);
		Employee employee2 = new Employee("emp", 1013, "mmm", 800);
		Employee employee3 = new Employee("emp", 1014, "nnn", 900);
		Employee employee4 = new Employee("emp", 1015, "ooo", 1010);

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
		boolean employee = dao.delete(id);

		return (employee == true) ? "Employee Deleted"
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

	@GET
	@Path("/rank/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public String findRank(@PathParam("id") int id) {

		EmployeeDao dao = new EmployeeDao();

		return dao.findRank(id);
	}

	@GET
	@Path("/salsum")
	@Produces(value = MediaType.APPLICATION_JSON)
	public String getSumOfSalaries() {

		EmployeeDao employeeDao = new EmployeeDao();

		return "The Sum of All Salaries of Employees : "
				+ employeeDao.getSumOfSalaries();
	}

}
