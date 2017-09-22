package com.wz.dao;

import java.util.List;

import com.wz.dto.AdminDto;
import com.wz.dto.Page;

public interface AdminDao {
	//查询 user info
    public AdminDto queryAdmins(AdminDto Admin) throws Exception;
    
    //获取 user information
    public List<AdminDto> getAdmins() throws Exception;
    
    //插入  user information
    public void insertAdmin(AdminDto Admin) throws Exception;
    
    //修改 user information
    public void updateAdmin(AdminDto Admin)throws Exception;
    
    //删除 user information 
    public void delectAdmin(AdminDto admin) throws Exception;
    
    //分页后的数据
    public List<AdminDto> getAdminPage(Page page) throws Exception;
}
