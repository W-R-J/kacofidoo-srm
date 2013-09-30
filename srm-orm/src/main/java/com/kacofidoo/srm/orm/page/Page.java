/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.orm.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.ui.Model;

import com.kacofidoo.srm.orm.utils.OrmConfig;

/**
 * 基础分页模型
 * 
 * @author Jeff.Tsai
 * 
 */
public class Page<T> {
	private static final String ATTR_NAME = OrmConfig.getConfig().getString("orm.page.attr");
	private static final int DEFAULT_PAGE_NO = 1;
	private static final int DEFAULT_PAGE_SIZE = 10;

	private int pageNo;
	private int pageSize;
	private List<T> result;
	private int totalSize;

	public static final <T> Page<T> build(List<T> result, Class<T> clazz, int pageNo, int pageSize, int totalSize) {
		return new Page<T>(result, pageNo, pageSize, totalSize);
	}

	public static final <T> Page<T> build(List<T> result, Class<T> clazz, int totalSize) {
		return new Page<T>(result, totalSize, DEFAULT_PAGE_NO, DEFAULT_PAGE_SIZE);
	}

	public static final <T> Page<T> build(List<T> result, Class<T> clazz, int totalSize, int pageNo) {
		return new Page<T>(result, totalSize, pageNo, DEFAULT_PAGE_SIZE);
	}

	public Page(List<T> result, int totalSize, int pageNo, int pageSize) {
		this.setPageNo(pageNo);
		this.setPageSize(pageSize);
		this.setResult(result);
		this.setTotalSize(totalSize);
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public List<T> getResult() {
		return result;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = Math.max(DEFAULT_PAGE_NO, pageNo);
	}

	public void setPageSize(int pageSize) {
		this.pageSize = Math.max(1, pageSize);
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = Math.max(0, totalSize);
	}

	public void toModel(Model model) {
		model.addAttribute(ATTR_NAME, CollectionUtils.isNotEmpty(this.getResult()) ? this.getResult() : CollectionUtils.EMPTY_COLLECTION);
	}
}
