package com.wz.test;

import java.util.ArrayList;
import java.util.List;

import com.wz.common.TagInfoUtil;
import com.wz.dto.MusicDto;
import com.wz.dto.Tag;

import net.sf.json.JSONArray;

public class HKCtest {

	public static void main(String[] args) {
		MusicCRUD m=new MusicCRUD();
		List<MusicDto> music=m.getMusic();
		
		JSONArray json=JSONArray.fromObject(music);
		List<String> list=new ArrayList<String>();
		list.add("G:\\CloudMusic\\李玖哲 - 夏天.mp3");
		list.add("G:\\CloudMusic\\丽江小倩 - 红蔷薇.mp3");
		list.add("G:\\CloudMusic\\马融 - 一瞬间.mp3");
		
		
		
		List<Tag> listTag=new ArrayList<Tag>();
		for (String string : list) {
			Tag tag=TagInfoUtil.Mp3InfoRead(string);
			TagInfoUtil.getMp3Picture(string);
			listTag.add(tag);
		}
		
		JSONArray json1=JSONArray.fromObject(listTag);
		System.out.println(json1);
		
		
		
		
		//System.out.println(music.toString());
	}

}
