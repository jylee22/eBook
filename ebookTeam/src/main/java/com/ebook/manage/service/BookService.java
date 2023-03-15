package com.ebook.manage.service;

import java.util.List;

import com.ebook.manage.vo.BookVo;

public interface BookService {
     
	
	//도서 목록
	List<BookVo> getBookList(BookVo bookVo);
    
	
	//도서 내용 불러오기
	BookVo getBook(int bookkey);
    
	
	//도서 추가
	void insertBook(BookVo bookVo);

	//도서 수정
	void updateBook(BookVo bookVo);
		
		
    //도서 삭제
	void deleteBook(int bookkey);

    
   
	
	
	

}
