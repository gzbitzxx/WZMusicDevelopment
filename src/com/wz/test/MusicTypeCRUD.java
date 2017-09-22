package com.wz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wz.dao.MusicTypeDao;
import com.wz.dao.UserDao;
import com.wz.dto.MusicTypeDto;
import com.wz.dto.Page;
import com.wz.dto.UserDto;

public class MusicTypeCRUD {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
	private static SqlSessionFactory sqlSessionFactory;

	public MusicTypeCRUD() {
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

	// 删除
	public boolean DeleteMusicType(MusicTypeDto dto) {
		SqlSession session = null;
		boolean de = false;
		try {
			session = sqlSessionFactory.openSession();
			MusicTypeDao musicTypeDao = session.getMapper(MusicTypeDao.class);
			musicTypeDao.delectMusicType(dto);
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
	public boolean AddMusicType(MusicTypeDto dto) {
		SqlSession session = null;
		boolean add = false;
		try {
			session = sqlSessionFactory.openSession();
			MusicTypeDao musicTypeDao = session.getMapper(MusicTypeDao.class);
			musicTypeDao.insertMusicType(dto);
			session.commit(true);
			add = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return add;
	}

	// 修改
	public boolean insertMusicType(MusicTypeDto dto) {
		SqlSession session = null;
		boolean b = false;
		session = sqlSessionFactory.openSession();
		MusicTypeDao musicTypeDao = session.getMapper(MusicTypeDao.class);
		try {
			musicTypeDao.updateMusicType(dto);
			session.commit(true);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 查询管理员
	public MusicTypeDto queryMusicType(MusicTypeDto dto) {
		SqlSession session = null;
		MusicTypeDto user = null;
		try {
			session = sqlSessionFactory.openSession();
			MusicTypeDao musicTypeDao = session.getMapper(MusicTypeDao.class);
			user = musicTypeDao.queryMusicTypes(dto);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	// 获取音乐类型列表
	public List<MusicTypeDto> getMusicType() {
		SqlSession session = session = sqlSessionFactory.openSession();
		List<MusicTypeDto> musicType = null;
		try {
			MusicTypeDao musicTypeDao = session.getMapper(MusicTypeDao.class);
			musicType = musicTypeDao.getMusicTypes();
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return musicType;
	}

	// 获取管理员列表
	public List<MusicTypeDto> getMusicTypePage(int currentPage, int pageSize) {
		SqlSession session = session = sqlSessionFactory.openSession();
		if (currentPage == 0) {
			currentPage = 1;
		}
		currentPage = (currentPage - 1) * pageSize;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);

		List<MusicTypeDto> musicType = null;
		try {
			MusicTypeDao musicTypeDao = session.getMapper(MusicTypeDao.class);
			musicType = musicTypeDao.getMusicTypePage(page);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return musicType;
	}
}
