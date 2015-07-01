package bbs.vienan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import bbs.vienan.bean.Page;
import bbs.vienan.bean.Reply;
import bbs.vienan.bean.User;
import bbs.vienan.dao.ReplyDao;
import bbs.vienan.dao.hibernate.ReplyDAO;


public class ReplyDaoImpl extends ReplyDAO implements ReplyDao {

	public List<Reply> queryByPage(final Long topicID,final Page pageBean) {
		return getHibernateTemplate().executeWithNativeSession(new HibernateCallback() {
			public List doInHibernate(Session s) throws HibernateException {
				// TODO Auto-generated method stub
				Query query=s.createQuery("from Reply r where r.topic.topicid=?");
				query.setParameter(0, topicID);
				query.setMaxResults(pageBean.getEveryPage());
				query.setFirstResult(pageBean.getBeginIndex());
				query.setCacheable(true);
				return query.list();
			}
		});
	}

	public int insert(Reply reply) {
		int row=1;
		try {
			save(reply);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			row=0;
		}
		return row;
		
	}

}
