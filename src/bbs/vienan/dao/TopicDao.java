package bbs.vienan.dao;

import java.util.List;

import bbs.vienan.bean.Topic;

public interface TopicDao {


	public List<Topic> getAllTopic(Long subItemID);

	public Topic getTopic(Long topicID);

	public int insert(Topic topic);

}
