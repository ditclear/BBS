package bbs.vienan.biz;

import java.util.List;

import bbs.vienan.bean.Topic;

public interface TopicBiz {

	public List<Topic> findALLTopic(Long subItemID);

	public Topic findTopic(Long topicID);

	public boolean addTopic(Topic topic);

}
