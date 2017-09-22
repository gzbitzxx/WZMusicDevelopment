package com.wz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wz.dao.MusicDao;
import com.wz.dao.MusicDao;
import com.wz.dto.MusicDto;
import com.wz.dto.Page;
import com.wz.dto.MusicDto;

public class MusicCRUD {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
	private static SqlSessionFactory sqlSessionFactory;

	public MusicCRUD() {
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
	public boolean DeleteMusic(MusicDto dto) {
		SqlSession session = null;
		boolean de = false;
		try {
			session = sqlSessionFactory.openSession();
			MusicDao musicDao = session.getMapper(MusicDao.class);
			musicDao.delectMusic(dto);
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
	public boolean AddMusic(MusicDto dto) {
		SqlSession session = null;
		boolean add = false;
		try {
			session = sqlSessionFactory.openSession();
			MusicDao musicDao = session.getMapper(MusicDao.class);
			musicDao.insertMusic(dto);
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
	public boolean insertMusic(MusicDto dto) {
		SqlSession session = null;
		boolean b = false;
		session = sqlSessionFactory.openSession();
		MusicDao musicDao = session.getMapper(MusicDao.class);
		try {
			musicDao.updateMusic(dto);
			session.commit(true);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 查询管理员
	public MusicDto queryMusic(MusicDto dto) {
		SqlSession session = null;
		MusicDto musicDto = null;
		try {
			session = sqlSessionFactory.openSession();
			MusicDao musicDao = session.getMapper(MusicDao.class);
			musicDto = musicDao.queryMusics(dto);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return musicDto;
	}

	// 获取管理员列表
	public List<MusicDto> getMusic() {
		SqlSession session = session = sqlSessionFactory.openSession();
		List<MusicDto> music = null;
		try {
			MusicDao musicDao = session.getMapper(MusicDao.class);
			music = musicDao.getMusics();
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return music;
	}
	
	// 获取管理员列表
	public List<MusicDto> getMusicsPage(int currentPage,int pageSize) {
		SqlSession session = session = sqlSessionFactory.openSession();
		
		if(currentPage==0){
			currentPage=1;
		}
		 currentPage=(currentPage-1)*pageSize;
		Page page=new Page();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		
		List<MusicDto> music = null;
		try {
			MusicDao musicDao = session.getMapper(MusicDao.class);
			music = musicDao.getMusicsPage(page);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return music;
	}
}
