/**
 * 
 */
package com.kacofidoo.srm.orm.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author weiwei.cai
 * 
 */
@Entity
@Table(name = "srm_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 6580920181947738980L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name", length = 30, nullable = false, unique = true)
	private String name;

	@Column(name = "description", length = 100, nullable = true)
	private String description;

	@ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.REMOVE })
	private Set<Permission> permissions;

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
