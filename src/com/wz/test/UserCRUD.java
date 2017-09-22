package com.wz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wz.dao.AdminDao;
import com.wz.dao.UserDao;
import com.wz.dto.AdminDto;
import com.wz.dto.Page;
import com.wz.dto.UserDto;

public class UserCRUD {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
	private static SqlSessionFactory sqlSessionFactory;

	public UserCRUD() {
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

	// 修改
	public boolean insertUser(UserDto dto) {
		SqlSession session = null;
		boolean b = false;
		session = sqlSessionFactory.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		try {
			userDao.updateUser(dto);
			session.commit(true);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 删除
	public boolean DeleteUser(UserDto dto) {
		SqlSession session = null;
		boolean de = false;
		try {
			session = sqlSessionFactory.openSession();
			UserDao userDao = session.getMapper(UserDao.class);
			userDao.delectUser(dto);
			session.commit(true);
			de = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return de;
	}

	// 添加
	public boolean AddUser(UserDto dto) {
		SqlSession session = null;
		boolean add = false;
		try {
			session = sqlSessionFactory.openSession();
			UserDao userDao = session.getMapper(UserDao.class);
			userDao.insertUser(dto);
			session.commit(true);
			add = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return add;
	}

	// 查询管理员
	public UserDto queryUser(UserDto dto) {
		SqlSession session = null;
		UserDto user = null;
		try {
			session = sqlSessionFactory.openSession();
			UserDao userDao = session.getMapper(UserDao.class);
			user = userDao.queryUsers(dto);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	// 获取管理员列表
	public List<UserDto> getUser() {
		SqlSession session = session = sqlSessionFactory.openSession();
		List<UserDto> user = null;
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			user = userDao.getUsers();
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	
	// 获取管理员列表
		public List<UserDto> getUsersPage(int currentPage, int pageSize) {
			SqlSession session = session = sqlSessionFactory.openSession();
			
			if (currentPage == 0) {
				currentPage = 1;
			}
			currentPage = (currentPage - 1) * pageSize;
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			
			List<UserDto> user = null;
			try {
				UserDao userDao = session.getMapper(UserDao.class);
				user = userDao.getUsersPage(page);
				session.commit(true);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return user;
		}

}
