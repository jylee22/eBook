package com.ebook.user.service;

import com.ebook.user.vo.UsersVO;

public interface UsersService {
    public void register(UsersVO usersVO) throws Exception;

    public UsersVO login(UsersVO loginDTO) throws Exception;

    public void update(UsersVO usersVO) throws Exception;

    public void delete(UsersVO usersVO) throws Exception;

    public int idcheck(UsersVO usersVO) throws Exception;


}
