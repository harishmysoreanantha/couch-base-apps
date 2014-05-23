package org.domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.domain.model.Employee;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class EmployeeMapper implements ResultSetMapper<Employee> {

	public Employee map(int arg0, ResultSet resultSet,
			StatementContext statementContext) throws SQLException {
		return new Employee(resultSet.getString("docType"),
				resultSet.getInt("id"), resultSet.getString("name"),
				resultSet.getDouble("salary"));

	}

}
