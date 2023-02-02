package com.ebook.api.dao;

import com.ebook.api.vo.ApiDTO;
import com.ebook.page.Criteria;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApiDAO {

    @Autowired
    SqlSession sqlSession;

    public void insert(ApiDTO apiDTO) throws Exception {
        sqlSession.insert("apiMapper.bookinsert", apiDTO);
    }

    public List<ApiDTO> list(Criteria cri) throws Exception {
        return sqlSession.selectList("apiMapper.booklist", cri);
    }

    public List<ApiDTO> getSearchList(ApiDTO apiDTO) throws Exception {
        return sqlSession.selectList("apiMapper.getSearchList", apiDTO);
    }

    // 책 종 갯수
    public int listCount() throws Exception{
        return sqlSession.selectOne("apiMapper.listCount");
    }

    public List<ApiDTO> getRandomList(ApiDTO apiDTO) throws Exception{
        return sqlSession.selectList("apiMapper.randomselect",apiDTO);
    }


}
