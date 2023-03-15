package com.ebook.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.manage.dao.BookDao;
import com.ebook.manage.service.BookService;
import com.ebook.manage.vo.BookVo;

@Service("bookService")
public class BookServiceImpl implements BookService {
    
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<BookVo> getBookList(BookVo bookVo) {
		List<BookVo> bookList = bookDao.getBookList(bookVo);
		return bookList;
	}
    
	//도서 정보 가져오기
	@Override
	public BookVo getBook(int bookkey) {
		BookVo bookVo = bookDao.getBook(bookkey);
		return bookVo;
	}
	
	//도서 추가
		@Override
		public void insertBook(BookVo bookVo) {
			bookDao.insertBook(bookVo);
			
		}
	
	//도서삭제
	@Override
	public void deleteBook(int bookkey) {
		bookDao.deleteBook(bookkey);
		
	}
     //도서 수정
	@Override
	public void updateBook(BookVo bookVo) {
		bookDao.updateBook(bookVo);
			
		
	}
    

}
