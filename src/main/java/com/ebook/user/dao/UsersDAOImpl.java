package com.ebook.user.dao;

import com.ebook.user.vo.UsersVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    SqlSession sqlSession;


    @Override
    public void register(UsersVO usersVO) throws Exception {
        sqlSession.insert("UserMapper.register", usersVO);
    }

    @Override
    public UsersVO login(UsersVO usersVO) throws Exception {
        return sqlSession.selectOne("UserMapper.login", usersVO);
    }

    @Override
    public void update(UsersVO usersVO) throws Exception {
        sqlSession.update("UserMapper.update", usersVO);
    }

    @Override
    public void delete(UsersVO usersVO) throws Exception {
        sqlSession.delete("UserMapper.delete", usersVO);

    }

    @Override
    public int idcheck(UsersVO usersVO) throws Exception {
        int result = sqlSession.selectOne("UserMapper.idcheck", usersVO);
        return result;
    }


}
