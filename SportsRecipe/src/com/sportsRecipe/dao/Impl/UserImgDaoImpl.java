package com.sportsRecipe.dao.Impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.dao.UserImgDao;
import com.sportsRecipe.entity.Userimg;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userimg entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.gcflower.entity1.Userimg
 * @author MyEclipse Persistence Tools
 */
public class UserImgDaoImpl extends HibernateDaoSupport implements UserImgDao{
	private static final Logger log = LoggerFactory.getLogger(UserImgDaoImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Userimg transientInstance) {
		log.debug("saving Userimg instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userimg persistentInstance) {
		log.debug("deleting Userimg instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userimg findById(java.lang.String id) {
		log.debug("getting Userimg instance with id: " + id);
		try {
			Userimg instance = (Userimg) getHibernateTemplate().get(
					"com.gcflower.entity1.Userimg", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userimg instance) {
		log.debug("finding Userimg instance by example");
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
		log.debug("finding Userimg instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userimg as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Userimg instances");
		try {
			String queryString = "from Userimg";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userimg merge(Userimg detachedInstance) {
		log.debug("merging Userimg instance");
		try {
			Userimg result = (Userimg) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userimg instance) {
		log.debug("attaching dirty Userimg instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userimg instance) {
		log.debug("attaching clean Userimg instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserImgDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (UserImgDaoImpl) ctx.getBean("UserimgDAO");
	}

	@Override
	public Userimg findImg(String userId) {
		List ul=getHibernateTemplate().find("from Userimg where userid=? ",
				new Object[]{userId});
		if(ul !=null && ul.size()>=1){
			return (Userimg)ul.get(0);
		}
		return null;
	}
}
