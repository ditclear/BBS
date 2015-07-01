package bbs.vienan.util;

import bbs.vienan.dao.IBaseHibernateDAO;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO extends HibernateDaoSupport /*implements IBaseHibernateDAO*/ {
	
	/*public Session getSession() {
		return HibernateSessionFactory.getSession();
	}*/
	
}