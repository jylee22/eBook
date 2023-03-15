package com.ebook.manage.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebook.manage.dao.UserDao;
import com.ebook.manage.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<UserVo> getUserList() {
		List<UserVo> userList = sqlSession.selectList("Manage.UserList");
		return userList;
	}

	@Override
	public UserVo getUserView(String userId) {
		UserVo user = sqlSession.selectOne("Manage.UserView", userId);
		return user;
	}

}
