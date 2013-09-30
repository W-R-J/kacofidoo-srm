/**
 * 
 */
package com.kacofidoo.srm.orm.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.transaction.annotation.Transactional;

import com.kacofidoo.srm.common.exception.SrmRuntimeException;
import com.kacofidoo.srm.orm.page.Page;

/**
 * @author weiwei.cai
 * 
 */
public class DaoSupportImpl<T> implements DaoSupport<T> {

	private Class<T> clazz;

	private String pojoName;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public DaoSupportImpl() {
		this.clazz = (Class<T>) this.getGenericType(0);
		this.pojoName = this.clazz.getCanonicalName();
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
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#delete(java.lang.Object[])
	 */
	@Override
	@Transactional
	public void delete(T... t) {
		for (T foo : t) {
			this.sessionFactory.getCurrentSession().delete(foo);
		}
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
		sb.append(this.pojoName);
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
		Criteria c = this.createCriteria(map);
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
		Criteria c = this.createCriteria(key, value);
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
		Criteria c = this.createCriteria(keys, values);
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
		return this.createCriteria(map).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByProperty(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByProperty(String key, Object value) {
		return this.createCriteria(key, value).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.dao.DaoSupport#queryByProperties(java.lang.String[], java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByProperties(String[] keys, Object[] values) {
		return this.createCriteria(keys, values).list();
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
	@Override
	public Page<T> queryByCriteriaWithPage(DetachedCriteria criteria, int pageNo, int pageSize) {
		Criteria c = criteria.getExecutableCriteria(this.sessionFactory.getCurrentSession());
		return this.fillPageByCriteria(c, pageNo, pageSize, null, null);
	}

	/**
	 * @param criteria
	 * @param pageNo
	 * @param pageSize
	 * @param orderBy
	 * @param isAsc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Page<T> fillPageByCriteria(Criteria criteria, int pageNo, int pageSize, String[] orderBy, boolean[] isAsc) {
		if (pageSize < 1) {
			throw new SrmRuntimeException("query with page error: pageSize<1 ");
		}
		CriteriaImpl cImpl = (CriteriaImpl) criteria;
		Projection p = cImpl.getProjection();

		Number foo = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
		int count = foo.intValue();
		criteria.setProjection(p);

		if (ArrayUtils.isNotEmpty(orderBy) && ArrayUtils.isNotEmpty(isAsc)) {
			if (orderBy.length != isAsc.length) {
				throw new SrmRuntimeException("order field array size doesn't equals with asc array size.");
			}
			for (int i = 0, len = orderBy.length; i < len; i++) {
				if (StringUtils.isNotBlank(orderBy[i])) {
					criteria.addOrder(isAsc[i] ? Order.asc(orderBy[i]) : Order.desc(orderBy[i]));
				}
			}
		}

		int from = Math.max((pageNo - 1) * pageSize, 0);
		int max = Math.max(1, pageNo) * pageSize - 1;
		List<T> li = criteria.setFirstResult(from).setMaxResults(max).list();
		return Page.build(li, this.clazz, pageNo, pageSize, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByMapForObject(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T queryByMapForObject(Map<String, Object> map) {
		Criteria c = this.createCriteria(map);
		return (T) c.setFirstResult(0).setMaxResults(1).uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByPropertiesForObject(java.lang.String[], java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T queryByPropertiesForObject(String[] keys, Object[] values) {
		Criteria c = this.createCriteria(keys, values);
		return (T) c.setFirstResult(0).setMaxResults(1).uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByPropertyForObject(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T queryByPropertyForObject(String key, Object value) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		return (T) c.add(Property.forName(key).eq(value)).setFirstResult(0).setMaxResults(1).uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll() {
		StringBuffer sb = new StringBuffer("select * from ").append(this.pojoName);
		Query query = this.sessionFactory.getCurrentSession().createQuery(sb.toString());
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#deleteAll()
	 */
	@Override
	public void deleteAll() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("delete from " + this.pojoName);
		query.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByPropertiesWithPage(java.lang.String[], java.lang.Object[],
	 * int, int)
	 */
	@Override
	public Page<T> queryByPropertiesWithPage(String[] keys, Object[] values, int pageNo, int pageSize) {
		return null;
	}

	private Criteria createCriteria(String key, Object value) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		if (StringUtils.isNotBlank(key)) {
			c.add(Property.forName(key).eq(value));
		}
		return c;
	}

	private Criteria createCriteria(Map<String, Object> map) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		for (Iterator<Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, Object> entry = it.next();
			if (StringUtils.isNotBlank(entry.getKey())) {
				c.add(Property.forName(entry.getKey()).eq(entry.getValue()));
			}
		}
		return c;
	}

	private Criteria createCriteria(String[] keys, Object[] values) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(this.clazz);
		if (ArrayUtils.isNotEmpty(keys) && ArrayUtils.isNotEmpty(values)) {
			if (keys.length != values.length) {
				throw new SrmRuntimeException("order field array size doesn't equals with asc array size.");
			}
			String key = null;
			Object value = null;
			for (int i = 0, len = keys.length; i < len; i++) {
				key = keys[i];
				value = values[i];
				c.add(Property.forName(key).eq(value));
			}
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByPropertiesWithPage(java.lang.String[], java.lang.Object[],
	 * int, int, java.lang.String)
	 */
	@Override
	public Page<T> queryByPropertiesWithPage(String[] keys, Object[] values, int pageNo, int pageSize, String orderBy) {
		return this.queryByPropertiesWithPage(keys, values, pageNo, pageSize, orderBy, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByPropertiesWithPage(java.lang.String[], java.lang.Object[],
	 * int, int, java.lang.String, boolean)
	 */
	@Override
	public Page<T> queryByPropertiesWithPage(String[] keys, Object[] values, int pageNo, int pageSize, String orderBy,
			boolean isAsc) {
		Criteria c = this.createCriteria(keys, values);
		return this.fillPageByCriteria(c, pageNo, pageSize, new String[] { orderBy }, new boolean[] { isAsc });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByPropertyWithPage(java.lang.String, java.lang.Object, int, int)
	 */
	@Override
	public Page<T> queryByPropertyWithPage(String key, Object value, int pageNo, int pageSize) {
		return this.queryByPropertyWithPage(key, value, pageNo, pageSize, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByPropertyWithPage(java.lang.String, java.lang.Object, int, int,
	 * java.lang.String)
	 */
	@Override
	public Page<T> queryByPropertyWithPage(String key, Object value, int pageNo, int pageSize, String orderBy) {
		return this.queryByPropertyWithPage(key, value, pageNo, pageSize, orderBy, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByPropertyWithPage(java.lang.String, java.lang.Object, int, int,
	 * java.lang.String, boolean)
	 */
	@Override
	public Page<T> queryByPropertyWithPage(String key, Object value, int pageNo, int pageSize, String orderBy,
			boolean isAsc) {
		Criteria c = this.createCriteria(key, value);
		return this.fillPageByCriteria(c, pageNo, pageSize, new String[] { orderBy }, new boolean[] { isAsc });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByMapWithPage(java.util.Map, int, int)
	 */
	@Override
	public Page<T> queryByMapWithPage(Map<String, Object> map, int pageNo, int pageSize) {
		return this.queryByMapWithPage(map, pageNo, pageSize, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByMapWithPage(java.util.Map, int, int, java.lang.String)
	 */
	@Override
	public Page<T> queryByMapWithPage(Map<String, Object> map, int pageNo, int pageSize, String orderBy) {
		return this.queryByMapWithPage(map, pageNo, pageSize, orderBy, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kacofidoo.srm.orm.utils.DaoSupport#queryByMapWithPage(java.util.Map, int, int, java.lang.String,
	 * boolean)
	 */
	@Override
	public Page<T> queryByMapWithPage(Map<String, Object> map, int pageNo, int pageSize, String orderBy, boolean isAsc) {
		Criteria criteria = this.createCriteria(map);
		return this.fillPageByCriteria(criteria, pageNo, pageSize, new String[] { orderBy }, new boolean[] { isAsc });
	}
}
