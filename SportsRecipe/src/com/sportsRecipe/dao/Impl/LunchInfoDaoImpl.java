package com.sportsRecipe.dao.Impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.dao.LunchInfoDao;
import com.sportsRecipe.entity.Lunchinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Lunchinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.gcflower.entity1.Lunchinfo
 * @author MyEclipse Persistence Tools
 */
public class LunchInfoDaoImpl extends HibernateDaoSupport implements LunchInfoDao{
	private static final Logger log = LoggerFactory
			.getLogger(LunchInfoDaoImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Lunchinfo transientInstance) {
		log.debug("saving Lunchinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Lunchinfo persistentInstance) {
		log.debug("deleting Lunchinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Lunchinfo findById(java.lang.String id) {
		log.debug("getting Lunchinfo instance with id: " + id);
		try {
			Lunchinfo instance = (Lunchinfo) getHibernateTemplate()
					.get("com.gcflower.entity1.Lunchinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Lunchinfo instance) {
		log.debug("finding Lunchinfo instance by example");
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
		log.debug("finding Lunchinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Lunchinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Lunchinfo instances");
		try {
			String queryString = "from Lunchinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Lunchinfo merge(Lunchinfo detachedInstance) {
		log.debug("merging Lunchinfo instance");
		try {
			Lunchinfo result = (Lunchinfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Lunchinfo instance) {
		log.debug("attaching dirty Lunchinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Lunchinfo instance) {
		log.debug("attaching clean Lunchinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LunchInfoDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (LunchInfoDaoImpl) ctx.getBean("LunchinfoDAO");
	}

	@Override
	public Lunchinfo findLunch(String string) {
		List ul=getHibernateTemplate().find("from Lunchinfo where lunchId=? ",
				new Object[]{string});
		if(ul !=null && ul.size()>=1){
			return (Lunchinfo)ul.get(0);
		}
		return null;
	}

}