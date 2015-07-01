package bbs.vienan.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import bbs.vienan.bean.Reply;
import bbs.vienan.bean.SubItem;
import bbs.vienan.bean.Topic;
import bbs.vienan.bean.User;
import bbs.vienan.biz.ReplyBiz;
import bbs.vienan.biz.SubItemBiz;
import bbs.vienan.biz.TopicBiz;
import bbs.vienan.biz.impl.ReplyBizImpl;
import bbs.vienan.biz.impl.SubItemBizImpl;
import bbs.vienan.biz.impl.TopicBizImpl;

public class ShowAllTopicAction {
	private Long subItemID;
	private String subItemName;
	private String title;
	private long userId;
	private String content;
	//鎵�湁topic
	private List<Topic> topicList;
	private ReplyBiz replyBiz;
	private TopicBiz topicBiz;
	private SubItemBiz subItemBiz;
	public String showAllTopic(){
		topicList=topicBiz.findALLTopic(subItemID);
		if (subItemName==null) {
			subItemName=subItemBiz.getSubName(subItemID);
		}
		return "success";
	}

	public String topicAdd(){
		Topic topic =new Topic();
		topic.setTitle(title);
		topic.setUsers(new User(userId));
		topic.setContent(content);
		topic.setHasread(200L);
		topic.setSubitem(new SubItem(subItemID));
		topic.setTopicdate(new Date());
		if(topicBiz.addTopic(topic)){
			return "success";
		}else{
			return "error";
		}
		
	}
	public Long getSubItemID() {
		return subItemID;
	}
	public void setSubItemID(Long subItemID) {
		this.subItemID = subItemID;
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	public String getSubItemName() {
		return subItemName;
	}
	public void setSubItemName(String subItemName) {
		this.subItemName = subItemName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ReplyBiz getReplyBiz() {
		return replyBiz;
	}
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	public TopicBiz getTopicBiz() {
		return topicBiz;
	}
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public SubItemBiz getSubItemBiz() {
		return subItemBiz;
	}
	public void setSubItemBiz(SubItemBiz subItemBiz) {
		this.subItemBiz = subItemBiz;
	}
}
