package com.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.model.ForumLike;

@Repository("forumLikeDAO")
public class ForumLikeDAOImpl implements ForumLikeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public ForumLikeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addForumLike(ForumLike forumLike) {
		sessionFactory.getCurrentSession().save(forumLike);
		return false;
		
	}

	public void delete(int forumLikeId) {
		ForumLike forumLikeToDelete = new ForumLike();
		forumLikeToDelete.setForumLikeId(forumLikeId);
		sessionFactory.getCurrentSession().delete(forumLikeToDelete);
		
	}

	public ForumLike get(int forumLikeId) {
		String hql = "from ForumLike where forumLikeID=" + "'" + forumLikeId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<ForumLike> listForumLike = (List<ForumLike>) query.list();

		if (listForumLike != null && !listForumLike.isEmpty()) {
			return listForumLike.get(0);
		}
		return null;
	}

	public List<ForumLike> listByForumId(int forumId) {
		String hql="from ForumLike where forumId= " + "'" + forumId + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ForumLike> list = (List<ForumLike>)query.list();
		return list;
	}

	public boolean forumLikeExists(int forumId, int userId) {
		String hql = "FROM ForumLike where forumId = '" + forumId + "' and userId = '" + userId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<ForumLike> listForumLike = (List<ForumLike>) query.list();
		return listForumLike.size() > 0 ? true : false; 
	}

}
