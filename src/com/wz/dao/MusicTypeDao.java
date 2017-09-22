package com.wz.dao;

import java.util.List;
import com.wz.dto.MusicTypeDto;
import com.wz.dto.Page;

public interface MusicTypeDao {
	//查询 user info
    public MusicTypeDto queryMusicTypes(MusicTypeDto MusicType) throws Exception;
    
    //获取 user information
    public List<MusicTypeDto> getMusicTypes() throws Exception;
    
    //插入  user information
    public void insertMusicType(MusicTypeDto MusicType) throws Exception;
    
    //修改 user information
    public void updateMusicType(MusicTypeDto MusicType)throws Exception;
    
    //删除 user information 
    public void delectMusicType(MusicTypeDto MusicType) throws Exception;
    
    //这是分页
    public List<MusicTypeDto> getMusicTypePage(Page page) throws Exception;
}
