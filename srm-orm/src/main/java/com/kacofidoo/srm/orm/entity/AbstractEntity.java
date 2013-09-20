/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.orm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jeff.Tsai
 * 
 */
public abstract class AbstractEntity implements Serializable {

	public static final int STORE_DEFAULT = 0;// 默认状态
	public static final int STORE_PUBLISH = 1;// 已经发布 
	public static final int STORE_FROZEN = -1;// 被冻结
	public static final int STORE_DELETE = -2;// 已标记删除

	private static final long serialVersionUID = 4066940986699055297L;

	private int status = STORE_DEFAULT;
	private Date createTime;
	private Date modifyTime;
	private long creator;
	private long modifier;
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @return the creator
	 */
	public long getCreator() {
		return creator;
	}
	/**
	 * @return the modifier
	 */
	public long getModifier() {
		return modifier;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(long creator) {
		this.creator = creator;
	}
	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(long modifier) {
		this.modifier = modifier;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}
