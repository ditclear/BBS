package bbs.vienan.biz;

import java.util.List;

import bbs.vienan.bean.SubItem;

public interface SubItemBiz {
	public List<SubItem> findAllSub(Long ItemID);

	public boolean addSubItem(SubItem subItem);

	public boolean deleteById(Long subItemID);

	public String getSubName(Long subItemID);
}
