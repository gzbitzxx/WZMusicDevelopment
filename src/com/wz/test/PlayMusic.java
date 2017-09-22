package com.wz.test;

import java.io.File;

import com.wz.common.TagInfoUtil;
import com.wz.dto.Tag;

public class PlayMusic {

	public static void main(String[] args) {
		String path="D://MyeclipseWorkSpace//.metadata//.me_tcat85//webapps//WZMusicDevelopment//upload//赵方婧 - 尽头.mp3";
		Tag tag=TagInfoUtil.Mp3InfoRead(path);
		System.out.println(tag.toString());
		
		TagInfoUtil.getMp3Picture(path);
	}

}
