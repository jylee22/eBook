package com.ebook.mylib.dao;

import com.ebook.mylib.dto.MyLibDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyLibDAO {
    @Autowired
    SqlSession sqlSession;

    public void insert(MyLibDTO myLibDTO) throws Exception {
        sqlSession.insert("booksMapper.libinsert", myLibDTO);
    }

    public List<MyLibDTO> select(MyLibDTO myLibDTO) throws Exception {
        return sqlSession.selectList("booksMapper.libselect", myLibDTO);
    }

}
