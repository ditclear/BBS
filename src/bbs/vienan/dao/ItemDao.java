package bbs.vienan.dao;

import java.util.List;

import bbs.vienan.bean.Item;
import bbs.vienan.bean.Page;

public interface ItemDao {
	public List<Item> queryItem() ;

	public int insert(Item item);

	public int deleteById(long itemID);

	public List<Item> queryByPage(Page pageBean);
}
