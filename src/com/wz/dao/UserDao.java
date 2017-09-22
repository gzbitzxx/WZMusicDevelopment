package com.wz.dao;

import java.util.List;

import com.wz.dto.Page;
import com.wz.dto.UserDto;

public interface UserDao {
	//查询 user info
    public UserDto queryUsers(UserDto user) throws Exception;
    
    //获取 user information
    public List<UserDto> getUsers() throws Exception;
    
    //插入  user information
    public void insertUser(UserDto user) throws Exception;
    
    //修改 user information
    public void updateUser(UserDto user)throws Exception;
    
    //删除 user information 
    public void delectUser(UserDto user) throws Exception;
    
    //获取分页 user information
    public List<UserDto> getUsersPage(Page page) throws Exception;
}
