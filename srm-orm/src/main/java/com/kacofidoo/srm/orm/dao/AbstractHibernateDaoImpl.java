package com.kacofidoo.srm.orm.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kacofidoo.srm.orm.page.Page;

abstract public class AbstractHibernateDaoImpl extends HibernateDaoSupport {

	@Inject
	protected SessionFactory sessionFactory;

	abstract protected Class<?> getEntityClass();

	public Object loadWithLazy(long id, String[] lazyItems) {
		// TODO 延迟加载
		
		throw new UnsupportedOperationException();
	}

	public int totalRecord() {
		// TODO 统计记录总数
		throw new UnsupportedOperationException();
	}

	public List<?> findAll() {
		return super.getHibernateTemplate().loadAll(getEntityClass());
	}

	public void save(Serializable bo) {
		super.getHibernateTemplate().save(bo);
	}

	public void deleteById(Serializable id) {
		Object entity = super.getHibernateTemplate().load(getEntityClass(), id);
		super.getHibernateTemplate().delete(entity);
	}

	public Object findById(Serializable id) {
		return super.getHibernateTemplate().get(getEntityClass(), id);
	}

	public void update(Serializable bo) {
		super.getHibernateTemplate().update(bo);
	}

	public List<?> findByProperty(String propertyName, Object value) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass()).add(
				Property.forName(propertyName).eq(value));
		return super.getHibernateTemplate().findByCriteria(criteria);
	}

	public List<?> findByMap(Map<String, Object> map) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
		for (Iterator<Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, Object> entry = it.next();
			criteria.add(Property.forName(entry.getKey()).eq(entry.getValue()));
		}
		return super.getHibernateTemplate().findByCriteria(criteria);
	}

	public List<?> findByHQL(String queryHQL, Object arg) {
		return super.getHibernateTemplate().find(queryHQL, arg);
	}

	public List<?> findByHQL(String queryHQL, List<?> args) {
		Query query = getSession().createQuery(queryHQL);
		return query.list();
	}

	public List<?> findByCriteria(DetachedCriteria paramDetachedCriteria) {
		return super.getHibernateTemplate().findByCriteria(paramDetachedCriteria);
	}

	public void clear() {
		super.getHibernateTemplate().clear();
	}

	public void flush() {
		super.getHibernateTemplate().flush();
	}

	public Page findByCriteriaWithPage(DetachedCriteria detachedCriteria, int startIndex, int pageSize) {
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (pageSize < 1) {
			pageSize = 1;
		}

		Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
		CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;
		Projection projection = criteriaImpl.getProjection();
		int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(projection);
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		List<?> list = criteria.setFirstResult(startIndex - 1).setMaxResults(pageSize).list();
		return new Page(list, totalCount, startIndex / pageSize, pageSize);
	}

}
