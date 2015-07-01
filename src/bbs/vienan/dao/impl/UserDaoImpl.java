package bbs.vienan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import bbs.vienan.bean.User;
import bbs.vienan.dao.BaseDao;
import bbs.vienan.dao.UserDao;
import bbs.vienan.dao.hibernate.UsersDAO;
@Repository("userDao")
public class UserDaoImpl extends UsersDAO implements UserDao {
	
	//查询用户
	public List<User> query(String username) {
		return findByUsername(username);
	}

	//插入用户
	public int insert(User user) {
		int row=1;
		
		try {
			save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			row=0;
		}
		return row;
	}
	//得到用户信息
	public User getUserInfo(User user) {
		try {
			return findByExample(user).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public boolean update(User user) {
		try {
			attachDirty(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public List<User> findAllUser(long popedom) {
		// TODO Auto-generated method stub
		return findByPopedom(popedom);
	}
	public int deleteById(long userid) {
		try {
			// TODO Auto-generated method stub
			delete(findById(userid));
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}

}
