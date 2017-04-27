package com.sportsRecipe.dao.Impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.dao.UserlogininfoDao;
import com.sportsRecipe.entity.Userlogininfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userlogininfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.gcflower.entity1.Userlogininfo
 * @author MyEclipse Persistence Tools
 */
public class UserlogininfoDaoImpl extends HibernateDaoSupport implements UserlogininfoDao {
	private static final Logger log = LoggerFactory
			.getLogger(UserlogininfoDaoImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Userlogininfo transientInstance) {
		log.debug("saving Userlogininfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userlogininfo persistentInstance) {
		log.debug("deleting Userlogininfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userlogininfo findById(java.lang.String id) {
		log.debug("getting Userlogininfo instance with id: " + id);
		try {
			Userlogininfo instance = (Userlogininfo) getHibernateTemplate()
					.get("com.gcflower.entity1.Userlogininfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userlogininfo instance) {
		log.debug("finding Userlogininfo instance by example");
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
		log.debug("finding Userlogininfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Userlogininfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Userlogininfo instances");
		try {
			String queryString = "from Userlogininfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userlogininfo merge(Userlogininfo detachedInstance) {
		log.debug("merging Userlogininfo instance");
		try {
			Userlogininfo result = (Userlogininfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userlogininfo instance) {
		log.debug("attaching dirty Userlogininfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userlogininfo instance) {
		log.debug("attaching clean Userlogininfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据用户名进行查询
	 * @param userName
	 * @return
	 */
	public Userlogininfo findUser(String userName){
		List ul=getHibernateTemplate().find("from Userlogininfo where username=? ",
				new Object[]{userName});
		if(ul !=null && ul.size()>=1){
			return (Userlogininfo)ul.get(0);
		}
		return null;
	}


	public static UserlogininfoDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserlogininfoDaoImpl) ctx.getBean("UserlogininfoDAO");
	}
}