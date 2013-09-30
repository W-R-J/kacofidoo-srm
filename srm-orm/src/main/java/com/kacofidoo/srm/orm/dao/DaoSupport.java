/**
 * 
 */
package com.kacofidoo.srm.orm.dao;

import java.io.Serializable;
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

	void deleteById(Serializable id);

	T load(Serializable id);

	T queryByCriteriaForObject(DetachedCriteria criteria);

	int queryByCirteriaForInt(DetachedCriteria criteria);

	int countAll();

	int countByCriteria(DetachedCriteria criteria);

	int countByMap(Map<String, Object> map);

	int countByProperty(String key, Object value);

	int countByProperties(String[] keys, Object[] values);

	List<T> queryByMap(Map<String, Object> map);

	List<T> queryByProperty(String key, Object value);

	List<T> queryByProperties(String[] keys, Object[] values);

	List<T> queryByCriteria(DetachedCriteria criteria);

	Page<T> queryByCriteriaWithPage(DetachedCriteria criteria, int pageNo, int pageSize);

}
