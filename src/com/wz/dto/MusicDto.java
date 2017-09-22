package com.wz.dto;

public class MusicDto {

	// 音乐编号
	private int id;

	// 歌手名字
	private String singer;

	// 音乐名称
	private String musicName;
	
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private MusicTypeDto mucicTypeDto;

	public MusicTypeDto getMucicTypeDto() {
		return mucicTypeDto;
	}

	public void setMucicTypeDto(MusicTypeDto mucicTypeDto) {
		this.mucicTypeDto = mucicTypeDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	@Override
	public String toString() {
		return "音乐信息：音乐名称" + musicName + "歌手姓名" + singer;
	}
}
