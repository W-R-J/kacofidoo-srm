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

	public static final int STORE_DEFAULT = 0;// 正常状态
	public static final int STORE_FROZEN = -1;// 被冻结
	public static final int STORE_DELETE = -2;// 已标记删除

	private static final long serialVersionUID = 4066940986699055297L;

	private int storeStatus = STORE_DEFAULT;

	private Date createTime;
	private Date modifyTime;
	private String creator;
	private String modifier;

	public int getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(int storeStatus) {
		this.storeStatus = storeStatus;
	}

}
