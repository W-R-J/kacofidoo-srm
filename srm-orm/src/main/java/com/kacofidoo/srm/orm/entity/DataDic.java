/**
 * 
 */
package com.kacofidoo.srm.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author weiwei.cai
 * 
 */
@Entity
@Table(name = "DATA_DIC")
public class DataDic implements Serializable {

	private static final long serialVersionUID = 6861009279162039284L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name", length = 255, nullable = false, unique = true)
	private String name;
	@Column(name = "value", length = 255)
	private String value;
	@Column(name = "catalog", length = 6)
	private long catalog;

	/**
	 * @return the catalog
	 */
	public long getCatalog() {
		return catalog;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param catalog
	 *            the catalog to set
	 */
	public void setCatalog(long catalog) {
		this.catalog = catalog;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
