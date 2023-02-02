package com.ebook.manage.service;

import java.util.List;

import com.ebook.manage.vo.UserVo;

public interface UserService {

	List<UserVo> getUserList();

	UserVo getUserView(String userId);

}
