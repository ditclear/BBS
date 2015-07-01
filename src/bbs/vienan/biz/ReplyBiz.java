package bbs.vienan.biz;

import java.util.List;

import bbs.vienan.bean.Page;
import bbs.vienan.bean.Reply;

public interface ReplyBiz {

	boolean addReply(Reply reply);

	List<Reply> queryByPage(Long topicID, Page pageBean);

}
