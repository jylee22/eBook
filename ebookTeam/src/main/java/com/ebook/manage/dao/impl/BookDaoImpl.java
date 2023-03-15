package com.ebook.manage.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebook.manage.dao.BookDao;
import com.ebook.manage.vo.BookVo;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    
	@Autowired
	private SqlSession sqlSession;
	
	
	//도서 목록
      @Override
	public List<BookVo> getBookList(BookVo bookVo) {
		return sqlSession.selectList("Book.Booklist",bookVo);
	}

    //도서 정보 가져오기
	@Override
	public BookVo getBook(int bookkey) {
		System.out.println(bookkey);
		return sqlSession.selectOne("Book.BookView", bookkey);
		
	}
    
	//도서 추가
	@Override
	public void insertBook(BookVo bookVo) {
	System.out.printf("DaoIm",bookVo);	
	sqlSession.insert("Book.BookInsert", bookVo);
	
	}		
	
    //도서 삭제
	@Override
	public void deleteBook(int bookkey) {
		 sqlSession.delete("Book.BookDelete", bookkey);
		
	}
	
    //도서 수정
	@Override
	public void updateBook(BookVo bookVo) {
		
		sqlSession.update("Book.BookUpdate", bookVo);
		
	}
    
		
	}


