package com.ebook.manage.dao;

import java.util.List;

import com.ebook.manage.vo.UserVo;

public interface UserDao {

	List<UserVo> getUserList();

	UserVo getUserView(String userId);

}
