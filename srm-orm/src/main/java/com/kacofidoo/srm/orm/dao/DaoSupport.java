/**
 * 
 */
package com.kacofidoo.srm.orm.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.kacofidoo.srm.orm.page.Page;

/**
 * @author weiwei.cai
 * 
 */
@Transactional
public interface DaoSupport<T> {

	void saveOrUpdate(T t);

	void delete(T t);

	void deleteById(Object id);

	T load(Object id);

	T queryByHqlForObject(String hql);

	T queryByCriteriaForObject(DetachedCriteria criteria);

	int queryByHqlForInt(String hql);

	int queryByCirteriaForInt(DetachedCriteria criteria);

	int countAll();

	int countByHql(String hql);

	int countByCriteria(DetachedCriteria criteria);

	List<T> queryByMap(Map<String, Object> map);

	List<T> queryByProperty(String key, Object value);

	List<T> queryByProperties(String[] keys, Object[] values);

	Page<T> queryByHqlWithPage(String hql, int pageNo, int pageSize);

	List<T> queryByHql(String hql);

	List<T> queryByCriteria(DetachedCriteria criteria);

	Page<T> queryByCriteriaWithPage(DetachedCriteria criteria, int pageNo, int pageSize);

}
