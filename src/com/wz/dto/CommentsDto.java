package com.wz.dto;

public class CommentsDto {

	// 编号
	private int id;

	// 用户id
	private UserDto userDto;

	// 音乐编号
	private MusicDto musicDto;

	// 评论
	private String words;

	// 点赞数量
	private int likeNumber;

	// 评论时间
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "CommentsDto [id=" + id + ", userDto=" + userDto + " words=" + words+"U"+musicDto
				+ ", likeNumber=" + likeNumber + ", date=" + date + userDto.toString() + "]";
	}

}
