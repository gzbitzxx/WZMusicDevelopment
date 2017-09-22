package com.wz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wz.dao.ArticleDao;
import com.wz.dao.MusicTypeDao;
import com.wz.dao.UserDao;
import com.wz.dto.ArticleDto;
import com.wz.dto.MusicTypeDto;
import com.wz.dto.Page;
import com.wz.dto.UserDto;

public class ArticleCRUD {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
	private static SqlSessionFactory sqlSessionFactory;

	public ArticleCRUD() {
		String resource = "wz-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 删除文章
	public boolean DeleteArticle(ArticleDto dto) {
		SqlSession session = null;
		boolean de = false;
		try {
			session = sqlSessionFactory.openSession();
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			articleDao.delectArticle(dto);
			session.commit(true);
			de = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return de;
	}

	// 添加文章
	public boolean AddArticle(ArticleDto dto) {
		SqlSession session = null;
		boolean add = false;
		try {
			session = sqlSessionFactory.openSession();
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			articleDao.insertArticle(dto);
			session.commit(true);
			add = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return add;
	}

	// 修改文章
	public boolean insertArticle(ArticleDto dto) {
		SqlSession session = null;
		boolean b = false;
		session = sqlSessionFactory.openSession();
		ArticleDao articleDao = session.getMapper(ArticleDao.class);
		try {
			articleDao.updateArticle(dto);
			session.commit(true);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 查询文章
	public ArticleDto queryArticle(ArticleDto dto) {
		SqlSession session = null;
		ArticleDto user = null;
		try {
			session = sqlSessionFactory.openSession();
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			user = articleDao.queryArticles(dto);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	
		// 查询文章
		public List<ArticleDto> queryMyselfArticles(ArticleDto dto) {
			SqlSession session = null;
			List<ArticleDto> user = null;
			try {
				session = sqlSessionFactory.openSession();
				ArticleDao articleDao = session.getMapper(ArticleDao.class);
				user = articleDao.queryMyselfArticles(dto);
				session.commit(true);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return user;
		}

	// 获取文章
	public List<ArticleDto> getArticle() {
		SqlSession session = session = sqlSessionFactory.openSession();
		List<ArticleDto> article = null;
		try {
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			article = articleDao.getArticles();
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return article;
	}
	
	// 获取文章
	public List<ArticleDto> getArticlePage(int currentPage,int pageSize) {
		SqlSession session = session = sqlSessionFactory.openSession();
		
		if(currentPage==0){
			currentPage=1;
		}
		 currentPage=(currentPage-1)*pageSize;
		Page page=new Page();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		
		List<ArticleDto> article = null;
		try {
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			article = articleDao.getArticlePage(page);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return article;
	}
}
