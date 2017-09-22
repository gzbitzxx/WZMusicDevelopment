package com.wz.dto;

public class MusicTypeDto {

	// 编号
	private int id;

	// 类型名称
	private String typeName;

	// 排序
	private int orderNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {

		return "音乐类型:" + typeName + "   orderNumber" + orderNumber;
	}
}
