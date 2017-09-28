package com.wz.dao;

import java.util.List;

import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.Page;

public interface MyMusicTypeDao {
	//查询 MyMusicType info
    public MyMusicTypeDto queryMyMusicTypes(MyMusicTypeDto MyMusicType) throws Exception;
    
    //获取 MyMusicType information
    public List<MyMusicTypeDto> getMyMusicTypes() throws Exception;
    
    //插入  MyMusicType information
    public void insertMyMusicType(MyMusicTypeDto MyMusicType) throws Exception;
    
    //修改 MyMusicType information
    public void updateMyMusicType(MyMusicTypeDto MyMusicType)throws Exception;
    
    //删除 MyMusicType information 
    public void delectMyMusicType(MyMusicTypeDto MyMusicType) throws Exception;
    
  //查询 MyMusicType 单个用户的文章
    public List<MyMusicTypeDto> queryMyselfMyMusicTypes(MyMusicTypeDto MyMusicType) throws Exception;
}
