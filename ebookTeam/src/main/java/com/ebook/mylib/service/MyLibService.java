package com.ebook.mylib.service;

import com.ebook.mylib.dao.MyLibDAO;
import com.ebook.mylib.dto.MyLibDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class MyLibService {
    @Autowired
    MyLibDAO myLibDAO;

    public void insertMyLib(MyLibDTO myLibDTO) throws Exception {
        myLibDAO.insert(myLibDTO);
    }

    public List<MyLibDTO> selectMylib(MyLibDTO myLibDTO) throws Exception {
        return myLibDAO.select(myLibDTO);

    }
}
