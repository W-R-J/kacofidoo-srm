/**
 * 
 */
package com.kacofidoo.srm.orm.utils;

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

	int countAll();

	int countByCriteria(DetachedCriteria criteria);

	int countByMap(Map<String, Object> map);

	int countByProperties(String[] keys, Object[] values);

	int countByProperty(String key, Object value);

	void deleteAll();

	void delete(T... t);

	void deleteById(Serializable id);

	T load(Serializable id);

	List<T> queryAll();

	int queryByCirteriaForInt(DetachedCriteria criteria);

	List<T> queryByCriteria(DetachedCriteria criteria);

	T queryByCriteriaForObject(DetachedCriteria criteria);

	Page<T> queryByCriteriaWithPage(DetachedCriteria criteria, int pageNo, int pageSize);

	Page<T> queryByPropertiesWithPage(String[] keys, Object[] values, int pageNo, int pageSize);

	Page<T> queryByPropertiesWithPage(String[] keys, Object[] values, int pageNo, int pageSize, String orderBy);

	Page<T> queryByPropertiesWithPage(String[] keys, Object[] values, int pageNo, int pageSize, String orderBy,
			boolean isAsc);

	Page<T> queryByPropertyWithPage(String key, Object value, int pageNo, int pageSize);

	Page<T> queryByPropertyWithPage(String key, Object value, int pageNo, int pageSize, String orderBy);

	Page<T> queryByPropertyWithPage(String key, Object value, int pageNo, int pageSize, String orderBy, boolean isAsc);

	Page<T> queryByMapWithPage(Map<String, Object> map, int pageNo, int pageSize);

	Page<T> queryByMapWithPage(Map<String, Object> map, int pageNo, int pageSize, String orderBy);

	Page<T> queryByMapWithPage(Map<String, Object> map, int pageNo, int pageSize, String orderBy, boolean isAsc);

	List<T> queryByMap(Map<String, Object> map);

	T queryByMapForObject(Map<String, Object> map);

	List<T> queryByProperties(String[] keys, Object[] values);

	T queryByPropertiesForObject(String[] keys, Object[] values);

	List<T> queryByProperty(String key, Object value);

	T queryByPropertyForObject(String key, Object value);

	void saveOrUpdate(T t);

}
