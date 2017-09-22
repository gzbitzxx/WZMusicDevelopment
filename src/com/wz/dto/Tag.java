package com.wz.dto;


/** 
 * 
 * @author TongZhou
 * 音乐解析类
 *
 */
public class Tag {
    private String SongName;
    private String Artist;
    private String Album;
    private String length;
    private String path;
    
    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSongName() {
        return SongName;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }
    public String getAlbum() {
        return Album;
    }
    public void setAlbum(String album) {
        Album = album;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

	@Override
	public String toString() {
		return "Tag [SongName=" + SongName + ", Artist=" + Artist + ", Album=" + Album + ", length=" + length + "]";
	}




}
