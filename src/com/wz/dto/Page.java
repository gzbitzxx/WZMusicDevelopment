package com.wz.dto;

public class Page {
	//页面的大小
	private int pageSize;
	
	//当前页数
	private int currentPage;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
