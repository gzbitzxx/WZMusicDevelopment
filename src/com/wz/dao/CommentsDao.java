package com.wz.dao;

import java.util.List;

import com.wz.dto.CommentsDto;
import com.wz.dto.Page;

public interface CommentsDao {
	//查询评论 info
    public CommentsDto queryComments(CommentsDto Comment) throws Exception;
    
    //获取 评论 information
    public List<CommentsDto> getComments() throws Exception;
    
    //插入  评论 information
    public void insertComment(CommentsDto Comment) throws Exception;
    
    //修改 评论 information
    public void updateComment(CommentsDto Comment)throws Exception;
    
    //删除 评论 information 
    public void delectComment(CommentsDto Comment) throws Exception;
    
    //获取 分页评论 information
    public List<CommentsDto> getCommentPage(Page page) throws Exception;
    
    
}
