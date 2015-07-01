package bbs.vienan.dao.hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bbs.vienan.bean.Item;
import bbs.vienan.util.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for Item
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see bbs.vienan.bean.Item
 * @author MyEclipse Persistence Tools
 */

public class ItemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ItemDAO.class);
	// property constants
	public static final String ITEMNAME = "itemname";
	public static final String ITEMDESCRIPTION = "itemdescription";
	public static final String MANAGER = "manager";

	public void save(Item transientInstance) {
		log.debug("saving Item instance");
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Item persistentInstance) {
		log.debug("deleting Item instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Item findById(java.lang.Long id) {
		log.debug("getting Item instance with id: " + id);
		try {
			Item instance = (Item) getHibernateTemplate().find(
					"from Item i where i.itemid=?", new Object[] { id }).get(0);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Item> findByExample(Item instance) {
		log.debug("finding Item instance by example");
		try {
			List<Item> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Item instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Item as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString,
					 value );
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Item> findByItemname(Object itemname) {
		return findByProperty(ITEMNAME, itemname);
	}

	public List<Item> findByItemdescription(Object itemdescription) {
		return findByProperty(ITEMDESCRIPTION, itemdescription);
	}

	public List<Item> findByManager(Object manager) {
		return findByProperty(MANAGER, manager);
	}

	public List findAll() {
		log.debug("finding all Item instances");
		try {
			String queryString = "from Item";
			return getHibernateTemplate().find(queryString, null);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Item merge(Item detachedInstance) {
		log.debug("merging Item instance");
		try {
			Item result = getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Item instance) {
		log.debug("attaching dirty Item instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Item instance) {
		log.debug("attaching clean Item instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}