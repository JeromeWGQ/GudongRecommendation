package com.sportsRecipe.dao.Impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.dao.UserinfoDao;
import com.sportsRecipe.entity.Userinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Userinfo
 * @author MyEclipse Persistence Tools
 */
public class UserinfoDaoImpl extends HibernateDaoSupport implements UserinfoDao{
	private static final Logger log = LoggerFactory
			.getLogger(UserinfoDaoImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Userinfo transientInstance) {
		log.debug("saving Userinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userinfo persistentInstance) {
		log.debug("deleting Userinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfo findById(java.lang.String id) {
		log.debug("getting Userinfo instance with id: " + id);
		try {
			Userinfo instance = (Userinfo) getHibernateTemplate().get(
					"entity.Userinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userinfo instance) {
		log.debug("finding Userinfo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Userinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Userinfo instances");
		try {
			String queryString = "from Userinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userinfo merge(Userinfo detachedInstance) {
		log.debug("merging Userinfo instance");
		try {
			Userinfo result = (Userinfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo instance) {
		log.debug("attaching dirty Userinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo instance) {
		log.debug("attaching clean Userinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserinfoDao getFromApplicationContext(ApplicationContext ctx) {
		return (UserinfoDao) ctx.getBean("UserinfoDAO");
	}
	
	/**
	 * 根据用户名进行查询
	 * @param userName
	 * @return
	 */
	public Userinfo findUser(String userName){
		List ul=getHibernateTemplate().find("from Userinfo where username=? ",
				new Object[]{userName});
		System.out.println(ul);
		System.out.println(ul.size());
		if(ul !=null && ul.size()>=1){
			return (Userinfo)ul.get(0);
		}
		return null;
	}
}