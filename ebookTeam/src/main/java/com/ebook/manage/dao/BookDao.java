package com.ebook.manage.dao;

import java.util.List;

import com.ebook.manage.vo.BookVo;

public interface BookDao {
	
   //책 목록
	List<BookVo> getBookList(BookVo bookVo);
   
	//도서 추가
	void insertBook(BookVo bookVo);
	

   // 도서 정보 불러오기
	BookVo getBook(int bookkey);
    
	
    //도서 수정
	void updateBook(BookVo bookVo);
	
   //도서 삭제
	void deleteBook(int bookkey);
   
	
    
   

}
