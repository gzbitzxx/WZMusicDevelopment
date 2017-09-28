package com.wz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wz.dao.MyMusicTypeDao;
import com.wz.dao.MyMusicTypeDao;
import com.wz.dao.MyMusicTypeDao;
import com.wz.dao.MyMusicTypeDao;
import com.wz.dao.MyMusicTypeDao;
import com.wz.dao.MyMusicTypeDao;
import com.wz.dao.MyMusicTypeDao;
import com.wz.dao.MyMusicTypeDao;
import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.Page;
import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.MyMusicTypeDto;
import com.wz.dto.MyMusicTypeDto;

public class MyMusicTypeCRUD {
	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
	private static SqlSessionFactory sqlSessionFactory;

	public MyMusicTypeCRUD() {
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

	// 查询我的音乐类型
	public MyMusicTypeDto queryMyMusicType(MyMusicTypeDto dto) {
		SqlSession session = null;
		MyMusicTypeDto mymusic = null;
		try {
			session = sqlSessionFactory.openSession();
			MyMusicTypeDao MyMusicTypeDao = session.getMapper(MyMusicTypeDao.class);
			mymusic = MyMusicTypeDao.queryMyMusicTypes(dto);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return mymusic;
	}

	// 删除我的音乐类型
	public boolean DeleteMyMusicType(MyMusicTypeDto dto) {
		SqlSession session = null;
		boolean de = false;
		try {
			session = sqlSessionFactory.openSession();
			MyMusicTypeDao myMusicTypeDao = session.getMapper(MyMusicTypeDao.class);
			myMusicTypeDao.delectMyMusicType(dto);
			session.commit(true);
			de = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return de;
	}

	// 添加我的音乐类型
	public boolean AddMyMusicType(MyMusicTypeDto dto) {
		SqlSession session = null;
		boolean add = false;
		try {
			session = sqlSessionFactory.openSession();
			MyMusicTypeDao myMusicTypeDao = session.getMapper(MyMusicTypeDao.class);
			myMusicTypeDao.insertMyMusicType(dto);
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
	public boolean insertMyMusicType(MyMusicTypeDto dto) {
		SqlSession session = null;
		boolean b = false;
		session = sqlSessionFactory.openSession();
		MyMusicTypeDao myMusicTypeDao = session.getMapper(MyMusicTypeDao.class);
		try {
			myMusicTypeDao.updateMyMusicType(dto);
			session.commit(true);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 查询文章
	public List<MyMusicTypeDto> queryMyselfMyMusicTypes(MyMusicTypeDto dto) {
		SqlSession session = null;
		List<MyMusicTypeDto> user = null;
		try {
			session = sqlSessionFactory.openSession();
			MyMusicTypeDao myMusicTypeDao = session.getMapper(MyMusicTypeDao.class);
			user = myMusicTypeDao.queryMyselfMyMusicTypes(dto);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	
	// 获取文章
		public List<MyMusicTypeDto> getMyMusicType() {
			SqlSession session = sqlSessionFactory.openSession();
			List<MyMusicTypeDto> myMusicType = null;
			try {
				MyMusicTypeDao myMusicTypeDao = session.getMapper(MyMusicTypeDao.class);
				myMusicType = myMusicTypeDao.getMyMusicTypes();
				session.commit(true);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return myMusicType;
		}
		
}
