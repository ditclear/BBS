package bbs.vienan.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xpath.internal.operations.Bool;

import bbs.vienan.bean.User;
import bbs.vienan.biz.UserBiz;
import bbs.vienan.dao.UserDao;
import bbs.vienan.dao.impl.UserDaoImpl;
@Service("userBiz") 
public class UserBizImpl implements UserBiz {
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public boolean cherlLongin(String username) {
		// TODO Auto-generated method stub
		List<User> list=userDao.query(username);
		return list.size()>0?true:false;
		/*System.out.println("保存用户信息到数据库");
	    throw new RuntimeException("为测试程序运行效果抛出的异常");*/
	}
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		int row=userDao.insert(user);
		return row>0?true:false;
	}
	public User findAll(User user) {
		// TODO Auto-generated method stub
		/*System.out.println("保存用户信息到数据库");
	    throw new RuntimeException("为测试程序运行效果抛出的异常");*/
		return userDao.getUserInfo(user);
	}
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		
		return userDao.update(user);
	}
	public List<User> findAllUser(long popedom) {
		// TODO Auto-generated method stub
		return userDao.findAllUser(popedom);
	}
	public boolean deleteById(long userid) {
		// TODO Auto-generated method stub
		int rows=userDao.deleteById(userid);
		return rows>0?true:false;
	}
}
