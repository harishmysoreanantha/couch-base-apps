package org.domain.dao;

import java.util.List;

import org.domain.model.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDao {

	@SqlUpdate("create table EMPLOYEE (id int not null primary key,docType varchar(20),name varchar(20),salary double)")
	void createEmployeeTable();

	@SqlUpdate("insert into EMPLOYEE(id, docType, name, salary) values(:id, :docType, :name, :salary)")
	void insertEmployee(@BindBean Employee employee);

	@SqlUpdate("update EMPLOYEE set name=:emp.name, docType=:emp.docType, salary:=emp.salary where id=:emp.id")
	void updateEmployee(@BindBean("emp") Employee employee);

	@SqlQuery("select * from EMPLOYEE where id =:id")
	Employee findById(@Bind("id") Integer id);

	@SqlQuery("select * from EMPLOYEE")
	List<Employee> getAll();

	@SqlUpdate("delete from EMPLOYEE where id =:id")
	void delete(@Bind("id") Integer id);

}
