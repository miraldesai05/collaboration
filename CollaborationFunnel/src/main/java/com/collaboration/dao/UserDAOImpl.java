package com.collaboration.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(User user) {
		user.setRole("user");
		sessionFactory.getCurrentSession().save(user);
	}

	public List<User> listUser() {
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>)sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	public void delete(int userId) {
		
		User userToDelete = new User();
		userToDelete.setUserId(userId);
		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}

	public User get(int userId) {
		
		String hql = "from User where userID=" + "'" + userId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	public void updateUser(User user) {
		
		User u =get(user.getUserId());
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setAddress(user.getAddress());
		u.setMobile(user.getMobile());
		u.setRole("user");
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		sessionFactory.getCurrentSession().update(u);
		
	}

	public User view(int userId) {
		
		String hql = "from User where userID=" + "'" + userId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	public User authenticate(String username, String password) {
		
		String hql = "from User where username=" + "'" + username + "' and " + " password='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
}
