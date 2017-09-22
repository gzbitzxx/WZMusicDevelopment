package com.wz.dto;

/*
 管理员实体
 */
public class UserDto {

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

	// 性别
	private String sex;

	// 年龄
	private int age;

	// 爱好
	private String hobby;

	// 生日
	private String brithday;

	// 关注数量
	private String view;

	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
	
	@Override
	public String toString() {
		return "用户信息：id=" + id + "accoutNumber=" + accoutNumber + "realName="
				+ realName + "loginIP=" + loginIP;

	}
}
