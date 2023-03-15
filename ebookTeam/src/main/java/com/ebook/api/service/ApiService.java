package com.ebook.api.service;

import com.ebook.api.dao.ApiDAO;
import com.ebook.api.vo.ApiDTO;
import com.ebook.page.Criteria;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ApiService {

    @Autowired
    ApiDAO apiDAO;
    //책 API -> DB 등록
    public void insertBook(ApiDTO apiDTO) throws Exception {
        apiDAO.insert(apiDTO);
    }

    //책 목록 조회
    public List<ApiDTO> list(Criteria cri) throws Exception {
        return apiDAO.list(cri);

    }
    //책 총 갯수
    public int listCount() throws Exception{
        return apiDAO.listCount();
    }

    //책 검색

    public List<ApiDTO> getSearchList(ApiDTO apiDTO) throws Exception {
        return apiDAO.getSearchList(apiDTO);
    }

    //책 랜덤 추출 홈화면
    public List<ApiDTO> getRandomList(ApiDTO apiDTO) throws Exception{
        return apiDAO.getRandomList(apiDTO);
    }

}
