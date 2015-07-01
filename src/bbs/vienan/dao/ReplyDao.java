package bbs.vienan.dao;

import java.util.List;

import bbs.vienan.bean.Page;
import bbs.vienan.bean.Reply;

public interface ReplyDao {

	int insert(Reply reply);

	List<Reply> queryByPage(Long topicID, Page pageBean);

}
