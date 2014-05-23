package org.domain.views;

import org.domain.model.Employee;

import com.yammer.dropwizard.views.View;

public class EditView extends View {

	private Employee employee;

	public EditView(Employee employee) {
		super("edit.ftl");
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

}
