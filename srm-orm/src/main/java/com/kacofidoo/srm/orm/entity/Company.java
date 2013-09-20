/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.orm.entity;

/**
 * @author Jeff.Tsai
 * 
 */
public class Company extends AbstractEntity {

	private static final long serialVersionUID = -7936879753209301450L;

	long id;

	String name;

	String description;

	String website;

	String address;

	String zipcode;

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @param zipcode
	 *            the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
