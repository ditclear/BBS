package bbs.vienan.dao.hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bbs.vienan.bean.SubItem;
import bbs.vienan.util.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Subitem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see bbs.vienan.bean.SubItem
 * @author MyEclipse Persistence Tools
 */

public class SubitemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SubitemDAO.class);
	// property constants
	public static final String SUBITEMNAME = "subitemname";
	public static final String ITEMDESCRIPTION = "itemdescription";
	public static final String TOPICID = "topicid";
	public static final String MANAGER = "manager";

	public void save(SubItem transientInstance) {
		log.debug("saving Subitem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SubItem persistentInstance) {
		log.debug("deleting Subitem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubItem findById(java.lang.Long id) {
		log.debug("getting Subitem instance with id: " + id);
		try {
			return (SubItem) getHibernateTemplate().find(
					"from SubItem s where s.subitemid=?", new Object[] { id })
					.get(0);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SubItem> findByExample(SubItem instance) {
		log.debug("finding Subitem instance by example");
		try {
			List<SubItem> results = getHibernateTemplate().findByExample(
					instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Subitem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Subitem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SubItem> findBySubitemname(Object subitemname) {
		return findByProperty(SUBITEMNAME, subitemname);
	}

	public List<SubItem> findByItemdescription(Object itemdescription) {
		return findByProperty(ITEMDESCRIPTION, itemdescription);
	}

	public List<SubItem> findByTopicid(Object topicid) {
		return findByProperty(TOPICID, topicid);
	}

	public List<SubItem> findByManager(Object manager) {
		return findByProperty(MANAGER, manager);
	}

	public List findAll() {
		log.debug("finding all Subitem instances");
		try {
			String queryString = "from Subitem";
			return getHibernateTemplate().find(queryString, null);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SubItem merge(SubItem detachedInstance) {
		log.debug("merging Subitem instance");
		try {
			SubItem result = getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SubItem instance) {
		log.debug("attaching dirty Subitem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubItem instance) {
		log.debug("attaching clean Subitem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}