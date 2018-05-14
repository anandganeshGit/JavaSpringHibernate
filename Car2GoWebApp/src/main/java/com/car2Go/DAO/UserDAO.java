package com.car2Go.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.car2Go.pojo.User;

public class UserDAO extends DAO {

		public UserDAO() {
		}

	public User get(String username) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}
	}

	public User create(String username, String password, String role, String emailId, String firstname, String lastname,
			String phonenumber, String address) throws Exception {
		try {
			begin();
			System.out.println("inside DAO");

			User user = new User(username, password, role);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setPhonenumber(phonenumber);
			user.setAddress(address);
			user.setEmailId(emailId);

			getSession().save(user);

			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws Exception {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete user " + user.getUsername(), e);
		}
	}
}