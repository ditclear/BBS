package bbs.vienan.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import bbs.vienan.bean.Item;
import bbs.vienan.bean.Page;
import bbs.vienan.dao.ItemDao;
import bbs.vienan.dao.hibernate.ItemDAO;

public class ItemDaoImpl extends ItemDAO implements ItemDao {
	public List<Item> queryItem() {
		// TODO Auto-generated method stub
		return findAll();
	}

	public int insert(Item item) {
		int row=1;
		try {
			save(item);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			row=0;
		}
		return row;
		
	}

	public int deleteById(long itemID) {
		try {
			delete(findById(itemID));
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public List<Item> queryByPage(final Page pageBean) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().executeWithNativeSession(new HibernateCallback() {

			public List doInHibernate(Session s) throws HibernateException {
				// TODO Auto-generated method stub
				Query query=s.createQuery("from Item i order by i.itemid");
				query.setMaxResults(pageBean.getEveryPage());
				query.setFirstResult(pageBean.getBeginIndex());
				return  query.list();
			}
		});
	}

}
