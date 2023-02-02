package com.ebook.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.manage.dao.UserDao;
import com.ebook.manage.service.UserService;
import com.ebook.manage.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserVo> getUserList() {
		List<UserVo> userList = userDao.getUserList();
		return userList;
	}

	@Override
	public UserVo getUserView(String userId) {
		UserVo user = userDao.getUserView(userId);
		return user;
	}

}
