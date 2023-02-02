package com.ebook.user.dao;


import com.ebook.user.vo.UsersVO;

public interface UsersDAO {

    public void register(UsersVO usersVO) throws Exception;

    public UsersVO login(UsersVO usersVO) throws Exception;

    public void update(UsersVO usersVO) throws Exception;

    public void delete(UsersVO usersVO) throws Exception;

    int idcheck(UsersVO usersVO) throws Exception;
}
