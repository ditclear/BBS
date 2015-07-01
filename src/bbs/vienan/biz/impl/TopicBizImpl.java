package bbs.vienan.biz.impl;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;

import bbs.vienan.bean.Topic;
import bbs.vienan.bean.User;
import bbs.vienan.biz.TopicBiz;
import bbs.vienan.biz.UserBiz;
import bbs.vienan.dao.TopicDao;
import bbs.vienan.dao.UserDao;
import bbs.vienan.dao.impl.TopicDaoImpl;
import bbs.vienan.dao.impl.UserDaoImpl;

public class TopicBizImpl implements TopicBiz {
	private TopicDao topicDao;
	public List<Topic> findALLTopic(Long subItemID) {
		// TODO Auto-generated method stub
		
		return topicDao.getAllTopic(subItemID);
	}
	public Topic findTopic(Long topicID) {
		// TODO Auto-generated method stub
		return topicDao.getTopic(topicID);
	}
	public boolean addTopic(Topic topic) {
		// TODO Auto-generated method stub
		int row=topicDao.insert(topic);
		return row>0?true:false;
	}
	public TopicDao getTopicDao() {
		return topicDao;
	}
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
}
