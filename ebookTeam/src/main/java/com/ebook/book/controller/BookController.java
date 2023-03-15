package com.ebook.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("book")
public class BookController {
	
	// 목록
	@RequestMapping("/list")
	public ModelAndView bookList() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("book/list");
		return mv;
	}
}
