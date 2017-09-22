package com.wz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wz.dao.AdminDao;
import com.wz.dto.AdminDto;
import com.wz.dto.Page;

public class AdminCRUD {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
	private static SqlSessionFactory sqlSessionFactory;

	public AdminCRUD() {
		String resource = "wz-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 修改
	public boolean insertAdmin(AdminDto dto) {
		SqlSession session = null;
		boolean b = false;
		session = sqlSessionFactory.openSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);
		try {
			adminDao.updateAdmin(dto);
			session.commit(true);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 删除
	public boolean DeleteAdmin(AdminDto dto) {
		SqlSession session = null;
		boolean de = false;
		try {
			session = sqlSessionFactory.openSession();
			AdminDao adminDao = session.getMapper(AdminDao.class);
			adminDao.delectAdmin(dto);
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
	public boolean AddAdmin(AdminDto dto) {
		SqlSession session = null;
		boolean add = false;
		try {
			session = sqlSessionFactory.openSession();
			AdminDao adminDao = session.getMapper(AdminDao.class);
			adminDao.insertAdmin(dto);
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
	public AdminDto queryAdmin(AdminDto dto) {
		SqlSession session = null;
		AdminDto admin = null;
		try {
			session = sqlSessionFactory.openSession();
			AdminDao adminDao = session.getMapper(AdminDao.class);
			admin = adminDao.queryAdmins(dto);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return admin;
	}

	// 获取管理员列表
	public List<AdminDto> getAdmins() {
		SqlSession session = sqlSessionFactory.openSession();
		List<AdminDto> admin = null;
		try {
			AdminDao adminDao = session.getMapper(AdminDao.class);
			admin = adminDao.getAdmins();
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return admin;
	}

	// 获取管理员列表
	public List<AdminDto> getAdminPage(int currentPage, int pageSize) {
		SqlSession session = sqlSessionFactory.openSession();
		if (currentPage == 0) {
			currentPage = 1;
		}
		currentPage = (currentPage - 1) * pageSize;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);

		List<AdminDto> admin = null;
		try {
			AdminDao adminDao = session.getMapper(AdminDao.class);
			admin = adminDao.getAdminPage(page);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return admin;
	}

}
