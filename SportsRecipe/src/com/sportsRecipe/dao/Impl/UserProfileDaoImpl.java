package com.sportsRecipe.dao.Impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.dao.UserProfileDao;
import com.sportsRecipe.entity.Userlogininfo;
import com.sportsRecipe.entity.Userprofile;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userprofile entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.gcflower.entity1.Userprofile
 * @author MyEclipse Persistence Tools
 */
public class UserProfileDaoImpl extends HibernateDaoSupport implements UserProfileDao{
	private static final Logger log = LoggerFactory
			.getLogger(UserProfileDaoImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Userprofile transientInstance) {
		log.debug("saving Userprofile instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userprofile persistentInstance) {
		log.debug("deleting Userprofile instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userprofile findById(java.lang.String id) {
		log.debug("getting Userprofile instance with id: " + id);
		try {
			Userprofile instance = (Userprofile) getHibernateTemplate().get(
					"com.gcflower.entity1.Userprofile", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userprofile instance) {
		log.debug("finding Userprofile instance by example");
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
		log.debug("finding Userprofile instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userprofile as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Userprofile instances");
		try {
			String queryString = "from Userprofile";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userprofile merge(Userprofile detachedInstance) {
		log.debug("merging Userprofile instance");
		try {
			Userprofile result = (Userprofile) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userprofile instance) {
		log.debug("attaching dirty Userprofile instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userprofile instance) {
		log.debug("attaching clean Userprofile instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserProfileDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserProfileDaoImpl) ctx.getBean("UserprofileDAO");
	}

	@Override
	public Userprofile findUser(String userId) {
			List ul=getHibernateTemplate().find("from Userprofile where userid=? ",
					new Object[]{userId});
			if(ul !=null && ul.size()>=1){
				return (Userprofile)ul.get(0);
			}
			return null;
		}
		
}