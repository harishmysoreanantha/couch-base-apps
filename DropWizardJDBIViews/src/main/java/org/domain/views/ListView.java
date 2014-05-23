package org.domain.views;

import java.util.List;

import org.domain.model.Employee;

import com.yammer.dropwizard.views.View;

public class ListView extends View {

	private List<Employee> list;

	public ListView(List<Employee> list) {
		super("list.ftl");
		this.list = list;
	}

	public List<Employee> getList() {
		return list;
	}

}
