package bbs.vienan.biz.impl;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;

import bbs.vienan.bean.Item;
import bbs.vienan.bean.Page;
import bbs.vienan.bean.User;
import bbs.vienan.biz.ItemBiz;
import bbs.vienan.biz.UserBiz;
import bbs.vienan.dao.ItemDao;
import bbs.vienan.dao.UserDao;
import bbs.vienan.dao.impl.ItemDaoImpl;
import bbs.vienan.dao.impl.UserDaoImpl;

public class ItemBizImpl implements ItemBiz {
	private ItemDao itemDao;
	public List<Item> findAllItem() {
		// TODO Auto-generated method stub
		return itemDao.queryItem();
	}
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		int row=itemDao.insert(item);
		return row>0?true:false;
	}
	public boolean deleteById(long itemID) {
		// TODO Auto-generated method stub
		int row=itemDao.deleteById(itemID);
		return row>0?true:false;
	}
	public List<Item> queryByPage(Page pageBean) {
		// TODO Auto-generated method stub
		return itemDao.queryByPage(pageBean);
	}
	public ItemDao getItemDao() {
		return itemDao;
	}
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
}
