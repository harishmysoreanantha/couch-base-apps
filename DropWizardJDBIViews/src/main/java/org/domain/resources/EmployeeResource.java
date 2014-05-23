package org.domain.resources;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.domain.dao.EmployeeDao;
import org.domain.model.Employee;
import org.domain.views.EditView;
import org.domain.views.ListView;

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

	@POST
	@Path("/create")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String createEmployees(@FormParam("employeeId") int employeeId,
			@FormParam("employeeName") String employeeName,
			@FormParam("employeeSalary") double employeeSalary) {

		Employee employee = new Employee("emp", employeeId, employeeName,
				employeeSalary);
		System.out.println(employee);
		employeeDao.insertEmployee(employee);

		return "1";
	}

	@GET
	@Path("/list")
	public ListView getListView() {
		return new ListView(employeeDao.getAll());
	}

	@GET
	@Path("/delete/{id}")
	@Produces(value = MediaType.TEXT_HTML)
	public ListView deleteEmployee(@PathParam("id") Integer id) {

		if (employeeDao.findById(id) != null) {
			employeeDao.delete(id);
			List<Employee> list = employeeDao.getAll();

			return new ListView(list);
		}

		return null;

	}

	@GET
	@Path("/find/{id}")
	@Produces(value = MediaType.TEXT_HTML)
	public EditView findById(@PathParam("id") Integer id) {
		System.out.println("The Id is : " + id);
		Employee employee = employeeDao.findById(id);

		return new EditView(employee);

	}

	@POST
	@Path("/update")
	@Produces(value = MediaType.TEXT_HTML)
	public String update(@FormParam("employeeId") int employeeId,
			@FormParam("employeeName") String employeeName,
			@FormParam("employeeSalary") double employeeSalary) {

		Employee employee = new Employee("emp", employeeId, employeeName,
				employeeSalary);

		employeeDao.updateEmployee(employee);

		System.out.println(employee);

		return "1";
	}

	// @GET
	// @Path("/find/{id}")
	// @Produces(value = MediaType.APPLICATION_JSON)
	// public String findById(@PathParam("id") Integer id) {
	// System.out.println("The Id is : " + id);
	// Employee employee = employeeDao.findById(id);
	//
	// return (employee != null) ? "Employee Found : " + employee
	// : "Employee Not Found !";
	//
	// }

	// private String buildResponse(List<Employee> list) {
	// StringBuilder builder = new StringBuilder();
	// builder.append(
	// "<table align=center border=1 cellpadding=5 cellspacing=4>")
	// .append("<tr>").append("<th>Employee Id</th>")
	// .append("<th>Name</th>").append("<th>Salary</th>")
	// .append("<th colspan='2'>Action</th>").append("</tr>");
	// for (Employee employee : list) {
	// builder.append("<tr>").append("<td>").append(employee.getId())
	// .append("</td>").append("<td>").append(employee.getName())
	// .append("</td>")
	// .append("<td>")
	// .append(employee.getSalary())
	// .append("</td>")
	// .append("<td>")
	// .append("<a href=")
	// // .append("/employee/delete/").append(employee.getId())
	// .append("#").append(" ").append("id=")
	// .append(employee.getId()).append(">Delete</a>")
	// .append("</td>").append("<td>").append("<a href=")
	// .append("#").append("").append(">Update</a>")
	// .append("</td>").append("</tr>");
	// }
	//
	// return builder.append("</table>").toString();
	//
	// }
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

	/*
	 * @GET
	 * 
	 * @Path("/list")
	 * 
	 * @Timed
	 * 
	 * @Produces(value = MediaType.TEXT_HTML) public String listAll() {
	 * 
	 * List<Employee> list = employeeDao.getAll();
	 * 
	 * 
	 * 
	 * // StringBuilder builder = new StringBuilder(); // builder.append( //
	 * "<table align=center border=1 cellpadding=5 cellspacing=4>") //
	 * .append("<tr>").append("<th>Employee Id</th>") //
	 * .append("<th>Name</th>").append("<th>Salary</th>") //
	 * .append("<th colspan='2'>Action</th>").append("</tr>"); // for (Employee
	 * employee : list) { //
	 * builder.append("<tr>").append("<td>").append(employee.getId()) //
	 * .append("</td>").append("<td>").append(employee.getName()) //
	 * .append("</td>").append("<td>") //
	 * .append(employee.getSalary()).append("</td>") //
	 * .append("<td>").append("<a href=") //
	 * .append("/employee/delete/").append(employee.getId()) //
	 * .append(">Delete</a>").append("</td>").append("<td>") //
	 * .append("<a href=").append("#").append("") //
	 * .append(">Update</a>").append("</td>").append("</tr>"); // }
	 * 
	 * return buildResponse(list).toString(); }
	 */

}
