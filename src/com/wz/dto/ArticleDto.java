package com.wz.dto;

import java.util.Date;

public class ArticleDto {

	//标题
	private String title;
	
	// 编号
	private int id;

	// 用户id
	private UserDto userDto;

	// 音乐编号id
	private MusicDto musicDto;

	// 文章内容
	private String words;

	// 点赞数量
	private int likeNumber;
	
	//创建的时间
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public MusicDto getMusicDto() {
		return musicDto;
	}

	public void setMusicDto(MusicDto musicDto) {
		this.musicDto = musicDto;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}
	
	@Override
	public String toString() {
		return "文章：id=" + id + "用户的信息  "+userDto.toString()+" Music信息    "+musicDto.toString()
				+"文章的内容   "+ words+"文章标题        "+title;
	}
}
