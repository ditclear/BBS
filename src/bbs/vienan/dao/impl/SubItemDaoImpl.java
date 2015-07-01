package bbs.vienan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import bbs.vienan.bean.Item;
import bbs.vienan.bean.SubItem;
import bbs.vienan.dao.BaseDao;
import bbs.vienan.dao.SubItemDao;
import bbs.vienan.dao.hibernate.SubitemDAO;

public class SubItemDaoImpl extends SubitemDAO implements SubItemDao {

	public List<SubItem> querySubItem(Long itemID) {
		if (itemID==0) {
			return (List<SubItem>) getHibernateTemplate().find("from SubItem s order by s.subitemid", null);
		}
		return (List<SubItem>) getHibernateTemplate().find(
				"from SubItem s where s.item.itemid=? order by s.subitemid",
				new Object[] { itemID });
	}

	public int insert(SubItem subItem) {
		int row=1;
		try {
			save(subItem);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			row=0;
		}
		return row;
	}

	public int deleteById(Long subItemID) {
		try {
			delete(findById(subItemID));
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public String getSubName(Long subItemID) {
		// TODO Auto-generated method stub
		return findById(subItemID).getSubitemname();
	}

}
