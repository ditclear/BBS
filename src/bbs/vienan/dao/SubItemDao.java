package bbs.vienan.dao;

import java.util.List;

import bbs.vienan.bean.SubItem;

public interface SubItemDao {
	public List<SubItem> querySubItem(Long itemID);

	public int insert(SubItem subItem);

	public int deleteById(Long subItemID);

	public String getSubName(Long subItemID);
}
