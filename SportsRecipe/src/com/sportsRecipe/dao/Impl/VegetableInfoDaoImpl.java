package com.sportsRecipe.dao.Impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.dao.VegetableInfoDao;
import com.sportsRecipe.entity.Userprofile;
import com.sportsRecipe.entity.Vegetableinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vegetableinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.gcflower.entity1.Vegetableinfo
 * @author MyEclipse Persistence Tools
 */
public class VegetableInfoDaoImpl extends HibernateDaoSupport implements VegetableInfoDao{
	private static final Logger log = LoggerFactory
			.getLogger(VegetableInfoDaoImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Vegetableinfo transientInstance) {
		log.debug("saving Vegetableinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vegetableinfo persistentInstance) {
		log.debug("deleting Vegetableinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vegetableinfo findById(java.lang.String id) {
		log.debug("getting Vegetableinfo instance with id: " + id);
		try {
			Vegetableinfo instance = (Vegetableinfo) getHibernateTemplate()
					.get("com.gcflower.entity1.Vegetableinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vegetableinfo instance) {
		log.debug("finding Vegetableinfo instance by example");
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
		log.debug("finding Vegetableinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Vegetableinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Vegetableinfo instances");
		try {
			String queryString = "from Vegetableinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vegetableinfo merge(Vegetableinfo detachedInstance) {
		log.debug("merging Vegetableinfo instance");
		try {
			Vegetableinfo result = (Vegetableinfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vegetableinfo instance) {
		log.debug("attaching dirty Vegetableinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vegetableinfo instance) {
		log.debug("attaching clean Vegetableinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VegetableInfoDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (VegetableInfoDaoImpl) ctx.getBean("VegetableinfoDAO");
	}

	@Override
	public Vegetableinfo findVegetable(String string) {
		List ul=getHibernateTemplate().find("from Vegetableinfo where vegetableId=? ",
				new Object[]{string});
		if(ul !=null && ul.size()>=1){
			return (Vegetableinfo)ul.get(0);
		}
		return null;
	}
}