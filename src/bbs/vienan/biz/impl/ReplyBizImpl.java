package bbs.vienan.biz.impl;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;

import bbs.vienan.bean.Page;
import bbs.vienan.bean.Reply;
import bbs.vienan.bean.User;
import bbs.vienan.biz.ReplyBiz;
import bbs.vienan.biz.UserBiz;
import bbs.vienan.dao.ReplyDao;
import bbs.vienan.dao.UserDao;
import bbs.vienan.dao.impl.ReplyDaoImpl;
import bbs.vienan.dao.impl.UserDaoImpl;

public class ReplyBizImpl implements ReplyBiz {
	private ReplyDao replyDao;
	public boolean addReply(Reply reply) {
		// TODO Auto-generated method stub
		int row=replyDao.insert(reply);
		return row>0?true:false;
	}
	public List<Reply> queryByPage(Long topicID, Page pageBean) {
		// TODO Auto-generated method stub
		return replyDao.queryByPage(topicID,pageBean);
	}
	public ReplyDao getReplyDao() {
		return replyDao;
	}
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
}
