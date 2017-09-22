package com.wz.dao;

import java.util.List;

import com.wz.dto.MusicDto;
import com.wz.dto.Page;

public interface MusicDao {
	//查询 user info
    public MusicDto queryMusics(MusicDto Music) throws Exception;
    
    //获取 user information
    public List<MusicDto> getMusics() throws Exception;
    
    //插入  user information
    public void insertMusic(MusicDto Music) throws Exception;
    
    //修改 user information
    public void updateMusic(MusicDto Music)throws Exception;
    
    //删除 user information 
    public void delectMusic(MusicDto Music) throws Exception;
    
    //获取分页 Music information
    public List<MusicDto> getMusicsPage(Page page) throws Exception;
}
