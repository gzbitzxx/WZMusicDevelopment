package com.wz.dao;

import java.util.List;
import com.wz.dto.ArticleDto;
import com.wz.dto.Page;

public interface ArticleDao {
	//查询 Article info
    public ArticleDto queryArticles(ArticleDto Article) throws Exception;
    
    //获取 Article information
    public List<ArticleDto> getArticles() throws Exception;
    
    //插入  Article information
    public void insertArticle(ArticleDto Article) throws Exception;
    
    //修改 Article information
    public void updateArticle(ArticleDto Article)throws Exception;
    
    //删除 Article information 
    public void delectArticle(ArticleDto Article) throws Exception;
    
  //获取 Article information
    public List<ArticleDto> getArticlePage(Page page) throws Exception;
    
  //查询 Article 单个用户的文章
    public List<ArticleDto> queryMyselfArticles(ArticleDto Article) throws Exception;
}
