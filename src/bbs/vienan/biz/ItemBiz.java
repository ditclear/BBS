package bbs.vienan.biz;

import java.util.List;

import bbs.vienan.bean.Item;
import bbs.vienan.bean.Page;

public interface ItemBiz {
	public List<Item> findAllItem() ;

	public boolean addItem(Item item);

	public boolean deleteById(long itemID);

	public List<Item> queryByPage(Page pageBean);
}
