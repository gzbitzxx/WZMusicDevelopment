package com.wz.common;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.flac.FlacFileReader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;
import org.jaudiotagger.tag.images.Artwork;

import com.wz.dto.Tag;

public class TagInfoUtil {

	public static Tag Mp3InfoRead(String path) {
		MP3File file;
		try {
			file = new MP3File(path);
			String songName = file.getID3v2Tag().frameMap.get("TIT2").toString();
			String artist = file.getID3v2Tag().frameMap.get("TPE1").toString();
			String album = file.getID3v2Tag().frameMap.get("TALB").toString();
			String length = file.getMP3AudioHeader().getTrackLengthAsString();
			songName = songName.substring(6, songName.length() - 3);
			artist = artist.substring(6, artist.length() - 3);
			album = album.substring(6, album.length() - 3);
			String songPath=path;

			Tag tag = new Tag();
			tag.setSongName(songName);
			tag.setAlbum(album);
			tag.setArtist(artist);
			tag.setLength(length);
			tag.setPath(songPath);
			return tag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取Mp3 tag信息出错！");

		}
	}

	public static Image getMp3Picture(String mp3path) {
		Image img;
		try {
			String url = mp3path;
			File sourceFile = new File(url);
			MP3File mp3file = new MP3File(sourceFile);

			AbstractID3v2Tag tag = mp3file.getID3v2Tag();
			AbstractID3v2Frame frame = (AbstractID3v2Frame) tag.getFrame("APIC");
			FrameBodyAPIC body = (FrameBodyAPIC) frame.getBody();
			byte[] imageData = body.getImageData();
			img = Toolkit.getDefaultToolkit().createImage(imageData, 0, imageData.length);
			ImageIcon icon = new ImageIcon(img);
			String storePath = mp3path;
			storePath = storePath.substring(0, storePath.length() - 3);
			storePath += "jpg";
			FileOutputStream fos = new FileOutputStream(storePath);
			fos.write(imageData);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("读取Mp3图片出错");
		}
		return img;
	}
}
