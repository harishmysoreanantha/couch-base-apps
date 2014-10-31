package org.tests;

import org.dao.UserDao;
import org.domain.Address;
import org.domain.User;
import org.util.CouchbaseUtil;

public class Test {

	public static void main(String[] args) {

		UserDao userDao = new UserDao();

		 Address address = new Address("address", "Bangalore", "India");
		 User user = new User("user", 111, "Sudarsan", "Ambatipudi", "male",
		 "asudarsan@sapient.com",
		 address);
		
		 userDao.saveOrUpdate(user);
		//
		// System.out.println(userDao.findById(111));

		// System.out.println(userDao.delete(111));

		// System.out.println(userDao.getAll());

		//System.out.println(userDao.getAllAddresses());

		CouchbaseUtil.closeClient();

	}

}
