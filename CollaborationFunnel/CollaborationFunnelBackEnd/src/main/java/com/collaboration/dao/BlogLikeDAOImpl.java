package com.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.model.BlogLike;

@Repository("blogLikeDAO")
public class BlogLikeDAOImpl implements BlogLikeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogLikeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addBlogLike(BlogLike blogLike) {
		sessionFactory.getCurrentSession().save(blogLike);
		
	}

	public void delete(int blogLikeId) {
		BlogLike blogLikeToDelete = new BlogLike();
		blogLikeToDelete.setBlogLikeId(blogLikeId);
		sessionFactory.getCurrentSession().delete(blogLikeToDelete);
		
	}

	public BlogLike get(int blogLikeId) {
		
		String hql = "from BlogLike where blogLikeID=" + "'" + blogLikeId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<BlogLike> listBlogLike = (List<BlogLike>) query.list();

		if (listBlogLike != null && !listBlogLike.isEmpty()) {
			return listBlogLike.get(0);
		}
		return null;
	}

	public List<BlogLike> listByBlogId(int blogId) {
		String hql="from BlogLike where blogId= " + "'" + blogId + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BlogLike> list = (List<BlogLike>)query.list();
		return list;
	}
}
