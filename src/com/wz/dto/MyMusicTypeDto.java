package com.wz.dto;

import javax.xml.crypto.Data;

public class MyMusicTypeDto {
	//编号
	private int id;
	
	private String name;
	
	//音乐实体
	private MusicDto musicDto;
	
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
	public MusicDto getMusicDto() {
		return musicDto;
	}
	public void setMusicDto(MusicDto musicDto) {
		this.musicDto = musicDto;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	@Override
	public String toString() {
		return "MyMusicTypeDto [id=" + id + ", name=" + name + ", musicDto=" + musicDto + ", userDto=" + userDto + "]";
	}
	
	

	
	
}
