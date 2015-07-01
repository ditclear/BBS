package bbs.vienan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import bbs.vienan.bean.Item;
import bbs.vienan.bean.Topic;
import bbs.vienan.bean.User;
import bbs.vienan.dao.BaseDao;
import bbs.vienan.dao.TopicDao;
import bbs.vienan.dao.hibernate.TopicDAO;

public class TopicDaoImpl extends TopicDAO implements TopicDao {

	public List<Topic> getAllTopic(Long subItemID) {
		return (List<Topic>) getHibernateTemplate().find(
				"from Topic t where t.subitem.subitemid=?",
				new Object[] { subItemID });
		
	}

	public Topic getTopic(Long topicID) {
		return findById(topicID);
	}
	public int insert(Topic topic) {
		int row=1;
		try {
			save(topic);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			row=0;
		}
		return row;
	}
}
