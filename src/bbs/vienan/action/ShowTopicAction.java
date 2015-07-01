package bbs.vienan.action;

import java.util.Date;
import java.util.List;

import bbs.vienan.bean.Page;
import bbs.vienan.bean.Reply;
import bbs.vienan.bean.Topic;
import bbs.vienan.bean.User;
import bbs.vienan.biz.ReplyBiz;
import bbs.vienan.biz.TopicBiz;
import bbs.vienan.biz.impl.ReplyBizImpl;
import bbs.vienan.biz.impl.TopicBizImpl;
import bbs.vienan.util.PageUtil;

public class ShowTopicAction {
	private Long subItemID;
	private Long topicID;
	private Topic topic;
	private Long id;
	private String content;
	private Long userId;
	private String replyDate;
	private List<Reply> replys;
	private String subItemName;
	private Page pageBean;
	private int curPage;
	//���ҵ�ǰ������
	private TopicBiz topicBiz;
	//���ҵ�ǰ�����µ����лظ�
	private ReplyBiz replyBiz;
	public String showTopic(){
		System.out.println("topicid:"+topicID);
		topic=topicBiz.findTopic(topicID);
		this.pageBean=PageUtil.createPage(2, topic.getReplies().size(), curPage);
		replys=replyBiz.queryByPage(topicID,pageBean);
		return "success";
	}
	public String replyAdd(){
		Reply reply=new Reply();
		reply.setTopic(new Topic(topicID));
		reply.setContent(content);
		reply.setUsers(new User(userId));
		reply.setReplydate(new Date());
		if(replyBiz.addReply(reply))
			return "success";
		else
			return "error";
	}
	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	public Long getSubItemID() {
		return subItemID;
	}
	public void setSubItemID(Long subItemID) {
		this.subItemID = subItemID;
	}
	public Long getTopicID() {
		return topicID;
	}
	public void setTopicID(Long topicID) {
		this.topicID = topicID;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getSubItemName() {
		return subItemName;
	}
	public void setSubItemName(String subItemName) {
		this.subItemName = subItemName;
	}
	public Page getPageBean() {
		return pageBean;
	}
	public void setPageBean(Page pageBean) {
		this.pageBean = pageBean;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public TopicBiz getTopicBiz() {
		return topicBiz;
	}
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	public ReplyBiz getReplyBiz() {
		return replyBiz;
	}
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
}
