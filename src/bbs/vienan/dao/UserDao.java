package bbs.vienan.dao;

import java.util.List;

import bbs.vienan.bean.User;

public interface UserDao {
	//��ѯ�û�
	public List<User> query(String username);
	//�����û�
	public int insert(User user);
	public boolean update(User user);
	public List<User> findAllUser(long popedom);
	public int deleteById(long userid);
	public User getUserInfo(User user);
}
