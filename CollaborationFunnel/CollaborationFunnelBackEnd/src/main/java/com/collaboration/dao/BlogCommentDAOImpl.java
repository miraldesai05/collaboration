package com.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.model.BlogComment;

@Repository("blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addBlogComment(BlogComment blogComment) {
		
		sessionFactory.getCurrentSession().save(blogComment);	
	}

	/*public List<BlogComment> listBlogComments() {
		
		@SuppressWarnings("unchecked")
		List<BlogComment> listBlogComment = (List<BlogComment>)sessionFactory.getCurrentSession().createCriteria(BlogComment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlogComment;
	}*/

	public void delete(int blogCommentId) {
		
		BlogComment blogCommentToDelete = new BlogComment();
		blogCommentToDelete.setBlogCommentId(blogCommentId);
		sessionFactory.getCurrentSession().delete(blogCommentToDelete);
	}

	public BlogComment get(int blogCommentId) {
		
		String hql = "from BlogComment where blogCommentID=" + "'" + blogCommentId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<BlogComment> listBlogComment = (List<BlogComment>) query.list();

		if (listBlogComment != null && !listBlogComment.isEmpty()) {
			return listBlogComment.get(0);
		}
		return null;
	}

	public void updateBlogComment(BlogComment blogComment) {
		BlogComment b =get(blogComment.getBlogCommentId());
		b.setBlogCommentContent(blogComment.getBlogCommentContent());
		sessionFactory.getCurrentSession().update(b);
		
	}

	public List<BlogComment> listByBlogId(int blogId) {
		String hql="from BlogComment where blogId= " + "'" + blogId + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BlogComment> list = (List<BlogComment>)query.list();
		return list;
	}

}
