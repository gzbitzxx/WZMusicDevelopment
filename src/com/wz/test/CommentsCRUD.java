package com.wz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wz.dao.CommentsDao;
import com.wz.dto.CommentsDto;
import com.wz.dto.Page;

public class CommentsCRUD {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
	private static SqlSessionFactory sqlSessionFactory;

	public CommentsCRUD() {
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

	// 删除评论
	public boolean delectComment(CommentsDto dto) {
		SqlSession session = null;
		boolean de = false;
		try {
			session = sqlSessionFactory.openSession();
			CommentsDao commentsDao = session.getMapper(CommentsDao.class);
			commentsDao.delectComment(dto);
			session.commit(true);
			de = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return de;
	}

	// 添加评论
	public boolean insertComment(CommentsDto dto) {
		SqlSession session = null;
		boolean add = false;
		try {
			session = sqlSessionFactory.openSession();
			CommentsDao commentDao = session.getMapper(CommentsDao.class);
			commentDao.insertComment(dto);
			session.commit(true);
			add = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return add;
	}

	// 修改评论
	public boolean updataComment(CommentsDto dto) {
		SqlSession session = null;
		boolean b = false;
		session = sqlSessionFactory.openSession();
		CommentsDao commentsDao = session.getMapper(CommentsDao.class);
		try {
			commentsDao.updateComment(dto);
			session.commit(true);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 查询评论
	public CommentsDto queryComment(CommentsDto dto) {
		SqlSession session = null;
		CommentsDto comment = null;
		try {
			session = sqlSessionFactory.openSession();
			CommentsDao commentDao = session.getMapper(CommentsDao.class);
			comment = commentDao.queryComments(dto);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return comment;
	}

	// 获取评论
	public List<CommentsDto> getComment() {
		SqlSession session = sqlSessionFactory.openSession();
		List<CommentsDto> commentlist = null;
		try {
			CommentsDao commentDao = session.getMapper(CommentsDao.class);
			commentlist = commentDao.getComments();
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return commentlist;
	}
	
	// 获取评论
		public List<CommentsDto> getCommentPage(int currentPage,int pageSize) {
			SqlSession session = sqlSessionFactory.openSession();
			
			if(currentPage==0){
				currentPage=1;
			}
			 currentPage=(currentPage-1)*pageSize;
			Page page=new Page();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			
			List<CommentsDto> commentlist = null;
			try {
				CommentsDao commentDao = session.getMapper(CommentsDao.class);
				commentlist = commentDao.getCommentPage(page);
				session.commit(true);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return commentlist;
		}
}
