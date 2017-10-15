package com.wz.dto;

public class MyMusicTypeDto {
	//编号
	private int id;
	
	//我的音乐类型名
	private String name;
	
	
	//用户实体
	private UserDto userDto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	@Override
	public String toString() {
		return "MyMusicTypeDto [id=" + id + ", name=" + name + ", userDto=" + userDto + "]";
	}
	
	
	

	
	
}
