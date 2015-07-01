package bbs.vienan.biz;

import java.sql.ResultSet;
import java.util.List;

import bbs.vienan.bean.User;

public interface UserBiz {
	//閿熸枻鎷烽敓鏂ゆ嫹閿熺煫浼欐嫹
	public boolean cherlLongin(String username);
	//閿熸枻鎷烽敓鏂ゆ嫹娌￠敓锟�	
	//public User findAll(String username, String password);
	public boolean updateUser(User user);
	public List<User> findAllUser(long popedom);
	public boolean addUser(User user);
	public boolean deleteById(long userid);
	public User findAll(User user);
}
