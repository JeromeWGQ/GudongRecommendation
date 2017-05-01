package com.sportsRecipe.dao.Impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.dao.SportsInfoDao;
import com.sportsRecipe.entity.Sportsinfo;
import com.sportsRecipe.entity.Userlogininfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sportsinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.gcflower.entity1.Sportsinfo
 * @author MyEclipse Persistence Tools
 */
public class SportsInfoDaoImpl extends HibernateDaoSupport implements SportsInfoDao{
	private static final Logger log = LoggerFactory
			.getLogger(SportsInfoDaoImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Sportsinfo transientInstance) {
		log.debug("saving Sportsinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sportsinfo persistentInstance) {
		log.debug("deleting Sportsinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sportsinfo findById(java.lang.String id) {
		log.debug("getting Sportsinfo instance with id: " + id);
		try {
			Sportsinfo instance = (Sportsinfo) getHibernateTemplate().get(
					"com.gcflower.entity1.Sportsinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sportsinfo instance) {
		log.debug("finding Sportsinfo instance by example");
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
		log.debug("finding Sportsinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sportsinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Sportsinfo instances");
		try {
			String queryString = "from Sportsinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sportsinfo merge(Sportsinfo detachedInstance) {
		log.debug("merging Sportsinfo instance");
		try {
			Sportsinfo result = (Sportsinfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sportsinfo instance) {
		log.debug("attaching dirty Sportsinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sportsinfo instance) {
		log.debug("attaching clean Sportsinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SportsInfoDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (SportsInfoDaoImpl) ctx.getBean("SportsinfoDAO");
	}

	@Override
	public Sportsinfo findSportsInfo(Userlogininfo data) {
		List ul=getHibernateTemplate().find("from Sportsinfo where userid=? ",
				new Object[]{data.getUserId()});
		if(ul !=null && ul.size()>=1){
			return (Sportsinfo)ul.get(0);
		}
		return null;
	}

	@Override
	public void addSportsInfo(Sportsinfo sportsInfo) {
		
		
	}
}