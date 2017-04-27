package com.sportsRecipe.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sportsRecipe.util.PageManager;


/**
 * DAO基类，提供一些共用的CRUD方法
 * @author Friday
 *
 */
public class BaseDao extends HibernateDaoSupport {

	/**
	 * 根据类名，主键值获取对应的类
	 * @param clazz	类名
	 * @param id	主键值
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public Object getObject(Class clazz, Serializable id) {
		
		Object o = getHibernateTemplate().get(clazz, id);
		return o;
	}

	
	/**
	 * 修改
	 * 如果没有对应的记录，merge会把该记录当作新的记录来插入
	 * @param object 所需要修改的类
	 */
	public void merge(Object object) {
		
		getHibernateTemplate().merge(object);
	}
	
	/**
	 * 修改
	 * 如果没有对应的记录，则会出错
	 * @param object 所需要修改的类
	 */
	public void update(Object object){
		this.getHibernateTemplate().update(object);
	}
	
	/**
	 *  保存
	 * @param object 所要保存的类
	 */
	public void save(Object object) {
		try{
			getHibernateTemplate().save(object);
		}catch (Exception e) {
			System.out.print(e);
		}
		
	}

	
	/**
	 * 删除
	 * @param clazz		类名
	 * @param id		主键值
	 */
	@SuppressWarnings("unchecked")
	public void removeObject(Class clazz, Serializable id) {
		
		getHibernateTemplate().delete(getHibernateTemplate().get(clazz, id));
	}

	/**
	 * 删除
	 * @param object
	 */
	public void delete(Object object){
		this.getHibernateTemplate().delete(object);
	}
	
	/**
	 * 删除所有
	 * @param entities
	 */
	@SuppressWarnings("unchecked")
	public void deleteAllObject(List entities){
		getHibernateTemplate().deleteAll(entities);
	}
	
	

	
	
	
	
	/**
	 * 返回的实例只有一个或者null
	 * 执行 select 语句
	 * @param hql
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object executeHql(final String hql, final Map map){
		Object result=null;
		try{
			result=this.getHibernateTemplate().execute(new HibernateCallback(){
				
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					
					Query query = session.createQuery(hql);
					Iterator it = map.keySet().iterator();
					while(it.hasNext()){
						Object key = it.next();   
			            query.setParameter(key.toString(), map.get(key));  
					}
					 return query.uniqueResult();
				}});
		}catch (RuntimeException re){
			throw re; 
		}
	
		return result;
	}

	
	/**
	 * 根据hql 和参数执行,返回执行影响的纪录数
	 * 一般来说0为不成功，大于0则就执行成功
	 * 执行 INSERT、UPDATE 或 DELETE 语句
	 * @param hql
	 * @param obj
	 * @return
	 */
	public Integer executeUpdateHql(final String hql,final Map map){
		Integer result=0;
		try{
			result=(Integer)this.getHibernateTemplate().execute(new HibernateCallback(){
				public Integer doInHibernate(Session session)
						throws HibernateException, SQLException {
					
					Query query = session.createQuery(hql);
					Iterator it = map.keySet().iterator();
					
					//替代参数
					while(it.hasNext()){
						Object key = it.next();   
			            query.setParameter(key.toString(), map.get(key));  
					}
					return query.executeUpdate();
				}});
		}catch (RuntimeException re){
			throw re; 
		}
		return result;
	}
	
	/**
	 * 分页查询 -无参
	 * @param hql
	 * @param page
	 */
	public void searchPaginated(String hql,PageManager page){
		//获取记录总数
		String countHql = getCountQuery(hql);
		Query query = getSession().createQuery(countHql);
		
		int total = ((Long)query.uniqueResult()).intValue();
		
		//获取结果集
		query = getSession().createQuery(hql);
		query.setFirstResult((page.getPage()-1)*page.getMaxResults());
		query.setMaxResults(page.getMaxResults());
		
		List datas = query.list();
		
		//把查询结果赋于分页类
		page.setDatas(datas);
		page.setRecordTotal(total);
	}
	
	/**
	 * 分页查询
	 * @param hql		
	 * @param map		参数集合
	 * @param starsize	起始下标
	 * @param pagesize	查询条数
	 * @return
	 */
	public void searchPaginated(String hql,Map map,PageManager page){
		
		//获取记录总数
		String countHql = getCountQuery(hql);
		Query query = getSession().createQuery(countHql);
		Iterator it = map.keySet().iterator();
		//替代参数
		while(it.hasNext()){
			Object key = it.next();   
            query.setParameter(key.toString(), map.get(key));  
		}
		int total = ((Long)query.uniqueResult()).intValue();
		//获取结果集
		query = getSession().createQuery(hql);
		it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();   
            query.setParameter(key.toString(), map.get(key));  
		}
		query.setFirstResult((page.getPage()-1)*page.getMaxResults());
		query.setMaxResults(page.getMaxResults());
		List datas = query.list();
		
		//把查询结果赋于分页类
		page.setDatas(datas);
		page.setRecordTotal(total);
		
	}
	
	
	/**
	 * 根据HQL语句，获得查询总记录数的HQL语句
	 * 如：
	 * select ... from Organization o where o.parent is null
	 * 经过转换，可以得到：
	 * select count(*) from Organziation o where o.parent is null
	 * @param hql
	 * @return
	 */
	private String getCountQuery(String hql){
		int index = hql.indexOf("from");
		if(index != -1){
			return "select count(*) " + hql.substring(index);
		}
		//throw new SystemException("无效的HQL查询语句【"+hql+"】");
		return "";
	}
	
	
	/**
	 * 查询列表
	 * @param hql		
	 * @param map		参数集合
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List searchList(String hql,Map map){
		
		Iterator it = map.keySet().iterator();
		//获取结果集
		Query query = getSession().createQuery(hql);
		it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();   
            query.setParameter(key.toString(), map.get(key));  
		}
		List datas = query.list();
		return datas;
		
	}
}
