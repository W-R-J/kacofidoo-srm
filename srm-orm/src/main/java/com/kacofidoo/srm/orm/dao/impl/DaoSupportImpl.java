/**
 * 
 */
package com.kacofidoo.srm.orm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.transaction.annotation.Transactional;

import com.kacofidoo.srm.common.exception.SrmRuntimeException;
import com.kacofidoo.srm.orm.dao.DaoSupport;
import com.kacofidoo.srm.orm.page.Page;

/**
 * @author weiwei.cai
 * 
 */
@Transactional
public class DaoSupportImpl<T> implements DaoSupport<T> {

	private Class<T> clazz;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public DaoSupportImpl() {
		this.clazz = (Class<T>) this.getGenericType(0);
	}

	/**
	 * 获取当前类的泛型类型
	 * 
	 * @param index
	 * @return
	 */
	private Class<?> getGenericType(int index) {
		Type genType = this.getClass().getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new RuntimeException("Index outof bounds");
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class<?>) params[index];
	}

	@Inject
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(T t) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#delete(java.lang.Object)
	 */
	@Override
	public void delete(T t) {
		this.sessionFactory.getCurrentSession().delete(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#deleteById(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(Serializable id) {
		T foo = (T) this.sessionFactory.getCurrentSession().load(this.clazz, id);
		this.delete(foo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#load(java.lang.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T load(Serializable id) {
		return (T) this.sessionFactory.getCurrentSession().load(this.clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByCriteriaForObject(org.hibernate.criterion.DetachedCriteria)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T queryByCriteriaForObject(DetachedCriteria criteria) {
		Criteria foo = criteria.getExecutableCriteria(this.sessionFactory.getCurrentSession());
		return (T) foo.setFirstResult(0).setMaxResults(1).uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByCirteriaForInt(org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public int queryByCirteriaForInt(DetachedCriteria criteria) {
		Criteria foo = criteria.getExecutableCriteria(this.sessionFactory.getCurrentSession());
		Number bar = (Number) foo.setFirstResult(0).setMaxResults(1).uniqueResult();
		return bar.intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#countAll()
	 */
	@Override
	public int countAll() {
		StringBuffer sb = new StringBuffer("select count(*) from ");
		sb.append(this.clazz.getSimpleName());
		Query query = this.sessionFactory.getCurrentSession().createQuery(sb.toString());
		Number foo = (Number) query.uniqueResult();
		return foo.intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#countByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public int countByCriteria(DetachedCriteria criteria) {
		Criteria foo = criteria.getExecutableCriteria(this.sessionFactory.getCurrentSession());
		Number count = (Number) foo.setProjection(Projections.rowCount()).uniqueResult();
		return count.intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#countByMap(java.util.Map)
	 */
	@Override
	public int countByMap(Map<String, Object> map) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		for (Iterator<Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, Object> entry = it.next();
			c.add(Property.forName(entry.getKey()).eq(entry.getValue()));
		}
		Number count = (Number) c.setProjection(Projections.rowCount()).uniqueResult();
		return count.intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#countByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public int countByProperty(String key, Object value) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		c.add(Property.forName(key).eq(value));
		Number foo = (Number) c.setProjection(Projections.rowCount()).uniqueResult();
		return foo.intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#countByProperties(java.lang.String[], java.lang.Object[])
	 */
	@Override
	public int countByProperties(String[] keys, Object[] values) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		for (int i = 0; i < keys.length; i++) {
			c.add(Property.forName(keys[i]).eq(values[i]));
		}
		Number foo = (Number) c.setProjection(Projections.rowCount()).uniqueResult();
		return foo.intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByMap(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByMap(Map<String, Object> map) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		for (Iterator<Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, Object> entry = it.next();
			c.add(Property.forName(entry.getKey()).eq(entry.getValue()));
		}
		return c.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByProperty(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByProperty(String key, Object value) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		return c.add(Property.forName(key).eq(value)).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByProperties(java.lang.String[], java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByProperties(String[] keys, Object[] values) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		for (int i = 0; i < keys.length; i++) {
			c.add(Property.forName(keys[i]).eq(values[i]));
		}
		return c.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByCriteria(DetachedCriteria criteria) {
		Criteria foo = criteria.getExecutableCriteria(this.sessionFactory.getCurrentSession());
		return foo.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByCriteriaWithPage(org.hibernate.criterion.DetachedCriteria, int,
	 * int)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page<T> queryByCriteriaWithPage(DetachedCriteria criteria, int pageNo, int pageSize) {
		if (pageSize < 1) {
			throw new SrmRuntimeException("query with page error: pageSize<1 ");
		}
		Criteria c = criteria.getExecutableCriteria(this.sessionFactory.getCurrentSession());
		CriteriaImpl cImpl = (CriteriaImpl) c;
		Projection p = cImpl.getProjection();

		Number foo = (Number) c.setProjection(Projections.rowCount()).uniqueResult();
		int count = foo.intValue();
		c.setProjection(p);
		int from = Math.max((pageNo - 1) * pageSize, 0);
		int max = Math.max(1, pageNo) * pageSize - 1;
		List li = c.setFirstResult(from).setMaxResults(max).list();
		return Page.build(li, this.clazz, pageNo, pageSize, count);
	}
}
