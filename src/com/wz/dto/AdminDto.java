package com.wz.dto;

/*
 管理员实体
 */
public class AdminDto {

	// 编号
	private int id;

	// 账号
	private String accoutNumber;

	// 真实姓名
	private String realName;

	// 登录IP
	private String loginIP;

	// 密码
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccoutNumber() {
		return accoutNumber;
	}

	public void setAccoutNumber(String accoutNumber) {
		this.accoutNumber = accoutNumber;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	@Override
	public String toString() {
		return "管理员信息：id=" + id + "accoutNumber=" + accoutNumber + "realName="
				+ realName + "loginIP=" + loginIP;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
