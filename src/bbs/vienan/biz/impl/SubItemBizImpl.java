package bbs.vienan.biz.impl;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;

import bbs.vienan.bean.SubItem;
import bbs.vienan.bean.User;
import bbs.vienan.biz.SubItemBiz;
import bbs.vienan.biz.UserBiz;
import bbs.vienan.dao.SubItemDao;
import bbs.vienan.dao.UserDao;
import bbs.vienan.dao.impl.SubItemDaoImpl;
import bbs.vienan.dao.impl.UserDaoImpl;

public class SubItemBizImpl implements SubItemBiz {
	private SubItemDao subItemDao;
	public List<SubItem> findAllSub(Long itemID){
		List<SubItem> subItems=subItemDao.querySubItem(itemID);
		return subItems;
	}
	public boolean addSubItem(SubItem subItem) {
		// TODO Auto-generated method stub
		int row=subItemDao.insert(subItem);
		return row>0?true:false;
	}
	public boolean deleteById(Long subItemID) {
		// TODO Auto-generated method stub
		int row=subItemDao.deleteById(subItemID);
		return row>0?true:false;
	}
	public String getSubName(Long subItemID) {
		// TODO Auto-generated method stub
		return subItemDao.getSubName(subItemID);
	}
	public SubItemDao getSubItemDao() {
		return subItemDao;
	}
	public void setSubItemDao(SubItemDao subItemDao) {
		this.subItemDao = subItemDao;
	}
}
