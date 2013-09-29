/**
 * 
 */
package com.kacofidoo.srm.orm.dao.impl;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

/**
 * @author weiwei.cai
 * 
 */
public class DaoSupportImpl<T> {

	@Inject
	private SessionFactory sessionFactory;

	public void insert(T t) {
		this.sessionFactory.getCurrentSession().save(t);
	}
	
}
