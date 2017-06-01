package com.sportsRecipe.dao.Impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.dao.BreakfastInfoDao;
import com.sportsRecipe.entity.Breakfastinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Breakfastinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.gcflower.entity1.Breakfastinfo
 * @author MyEclipse Persistence Tools
 */
public class BreakfastInfoDaoImpl extends HibernateDaoSupport implements BreakfastInfoDao{
	private static final Logger log = LoggerFactory
			.getLogger(BreakfastInfoDaoImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Breakfastinfo transientInstance) {
		log.debug("saving Breakfastinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Breakfastinfo persistentInstance) {
		log.debug("deleting Breakfastinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Breakfastinfo findById(java.lang.String id) {
		log.debug("getting Breakfastinfo instance with id: " + id);
		try {
			Breakfastinfo instance = (Breakfastinfo) getHibernateTemplate()
					.get("com.gcflower.entity1.Breakfastinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Breakfastinfo instance) {
		log.debug("finding Breakfastinfo instance by example");
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
		log.debug("finding Breakfastinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Breakfastinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Breakfastinfo instances");
		try {
			String queryString = "from Breakfastinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Breakfastinfo merge(Breakfastinfo detachedInstance) {
		log.debug("merging Breakfastinfo instance");
		try {
			Breakfastinfo result = (Breakfastinfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Breakfastinfo instance) {
		log.debug("attaching dirty Breakfastinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Breakfastinfo instance) {
		log.debug("attaching clean Breakfastinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BreakfastInfoDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (BreakfastInfoDaoImpl) ctx.getBean("BreakfastinfoDAO");
	}

	@Override
	public Breakfastinfo findBreakfast(String string) {
		List ul=getHibernateTemplate().find("from Breakfastinfo where breakfastId=? ",
				new Object[]{string});
		if(ul !=null && ul.size()>=1){
			return (Breakfastinfo)ul.get(0);
		}
		return null;
	}

}