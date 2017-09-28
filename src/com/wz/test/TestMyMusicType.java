package com.wz.test;

import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.UserDto;

public class TestMyMusicType {

	public static void main(String[] args) {
		MyMusicTypeCRUD m=new MyMusicTypeCRUD();
		
		//通过用户查询
		//MyMusicTypeDto my=new MyMusicTypeDto();
		//my.setId(1);
		//MyMusicTypeDto dto=m.queryMyMusicType(my);
		//System.out.println(dto.toString());
		
		//输出类型名称
		System.out.println(m.getMyMusicType().toString());
		
		//插入我的音乐类型
		MyMusicTypeDto dto=new MyMusicTypeDto();
		
		UserDto userDto=new UserDto();
		userDto.setId(5);
//		dto.setId(3);
//		dto.setName("非常喜欢");
//		dto.setUserDto(userDto);
//		Boolean b=m.AddMyMusicType(dto);
//		if(b){
//			System.out.println("插入成功！");
//		}
		
		//删除我的音乐类型
//		dto.setId(2);
//		Boolean b=m.DeleteMyMusicType(dto);
//		if(b){
//			System.out.println("删除成功！");
//		}
		
		//修改我的音乐类型
//		dto.setId(1);
//		dto.setName("特别喜欢的音乐");
//		dto.setUserDto(userDto);
//		
//		Boolean b=m.insertMyMusicType(dto);
//		if(b){
//			System.out.println("修改成功！");
//		}
	}

}
