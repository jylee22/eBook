package com.ebook.manage.controller;

import java.util.List;

import com.ebook.api.vo.ApiDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.ebook.manage.service.BookService;
import com.ebook.manage.service.MenuService;
import com.ebook.manage.service.RequestService;
import com.ebook.manage.service.UserService;
import com.ebook.manage.vo.BookVo;
import com.ebook.manage.vo.MenuVo;
import com.ebook.manage.vo.RequestVo;
import com.ebook.manage.vo.UserVo;
import com.ebook.subscr.service.SubscribeService;
import com.ebook.subscr.vo.SubscrVo;

@Controller()
@Log4j2
@RequestMapping("manage")
public class ManageController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private SubscribeService subscribeService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private BookService bookService;
			
	// 회원관리
	@RequestMapping("/user")
	public ModelAndView userList() {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 회원 목록
		List<UserVo> userList = userService.getUserList();

		List<MenuVo> myMenu = menuService.getMyMenu();
		List<MenuVo> boardMenu = menuService.getBoardMenu();

		
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("userList", userList);
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		
		mv.setViewName("manage/user/userList");
		return mv;
	}
	
	// 회원정보
	@RequestMapping("/user/view")
	public ModelAndView userView(String userId) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 회원 정보
		UserVo user = userService.getUserView(userId);
		
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("user", user);
		
		mv.setViewName("manage/user/userView");
		return mv;
	}
	
	// 메뉴관리
	@RequestMapping("/menu")
	public ModelAndView menuList( ) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 메뉴 목록
		List<MenuVo> menuList = menuService.getMenuList();
		
		mv.addObject("menuList", menuList);
		mv.addObject("manageMenu", manageMenu);
		
		mv.setViewName("manage/menu/menuList");
		return mv;
	}

	// 메뉴관리 : 보기
	@RequestMapping("/menu/view")
	public ModelAndView menuView(int menu_seq) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		List<MenuVo> menuList = menuService.getMenuList();
		
		// 메뉴 정보 보기
		MenuVo menu = menuService.getMenu(menu_seq);
		
		mv.addObject("menuList", menuList);
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("menu", menu);
		
		mv.setViewName("manage/menu/menuView");
		return mv;
	}
	
	// 메뉴관리 : 등록
	@RequestMapping("/menu/writeForm")
	public ModelAndView menuWriteForm(String postCategory) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		List<MenuVo> menuList = menuService.getMenuList();
		
		mv.addObject("menuList", menuList);
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("postCategory",postCategory);
		
		mv.setViewName("manage/menu/menuWrite");
		return mv;
	}
	
	// 메뉴관리 : 등록
	@RequestMapping("/menu/write")
	public ModelAndView menuWrite(MenuVo menu) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		List<MenuVo> menuList = menuService.getMenuList();
		
		menuService.insertMenu(menu);
		
		mv.addObject("menuList", menuList);
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("menu",menu);
		
		mv.setViewName("redirect:/manage/menu");
		return mv;
	}
	
	// 메뉴관리 : 수정
	@RequestMapping("/menu/updateForm")
	public ModelAndView menuUpdateFrom(int menu_seq) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		List<MenuVo> menuList = menuService.getMenuList();
		
		// 메뉴 정보 가져오기
		MenuVo menu = menuService.getMenu(menu_seq);
				
		mv.addObject("menuList", menuList);
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("menu", menu);
		mv.addObject("menu_seq", menu_seq);
		
		mv.setViewName("manage/menu/menuUpdate");
		return mv;
	}
	
	// 메뉴관리 : 수정
	@RequestMapping("/menu/update")
	public ModelAndView menuUpdate(MenuVo menu) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		List<MenuVo> menuList = menuService.getMenuList();
		
		menuService.updateMenu(menu);
		
		mv.addObject("menuList", menuList);
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("menu",menu);
		
		mv.setViewName("redirect:/manage/menu");
		return mv;
	}
	
	// 메뉴관리 : 삭제
	@RequestMapping("/menu/delete")
	public ModelAndView menuUpdate(int menu_seq) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		List<MenuVo> menuList = menuService.getMenuList();
		
		//menuService.deleteMenu(menu_seq);
		
		mv.addObject("menuList", menuList);
		mv.addObject("manageMenu", manageMenu);
		//mv.addObject("menu_seq",menu_seq);
		
		mv.setViewName("manage/menu");
		return mv;
	}
	
	// 구독관리
	@RequestMapping("/subscr")
	public ModelAndView subscrList() {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 구독 목록
		List<SubscrVo> subscrList = subscribeService.getSubscrList();

		mv.addObject("manageMenu", manageMenu);
		mv.addObject("subscrList", subscrList);
		
		mv.setViewName("manage/subscr/subscrList");
		return mv;
	}
	
	@RequestMapping("/subscr/view")
	public ModelAndView subscrView(String userId) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 구독 정보
		SubscrVo subscr = subscribeService.getSubscrView(userId);
		log.info("333333333333333333");
		log.info(subscr);

		mv.addObject("manageMenu", manageMenu);
		mv.addObject("subscr", subscr);
		
		mv.setViewName("manage/subscr/subscrView");
		return mv;
	}
	
	// 요청 관리 : 목록
	@RequestMapping("/request")
	public ModelAndView reqestList() {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 목록
		List<RequestVo> requestList = requestService.getRequestList();
		
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("requestList", requestList);
		mv.setViewName("manage/request/requestList");
		return mv;
	}
	
	// 요청 관리 : 보기
	@RequestMapping("/request/view")
	public ModelAndView reqestView(int req_key) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 목록
		RequestVo request = requestService.getRequestView(req_key);
		
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("request", request);
		mv.setViewName("manage/request/requestView");
		return mv;
	}
	
	// 요청 관리 : 수정
	@RequestMapping("/request/updateForm")
	public ModelAndView requestUpdateForm(int req_key) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 목록 가져오기
		RequestVo request = requestService.getRequest(req_key);
				
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("request", request);
		mv.setViewName("manage/request/requestUpdate");
		return mv;
	}
	
	// 요청 관리 : 수정
	@RequestMapping("/request/update")
	public ModelAndView requestUpdate(RequestVo request) {
		ModelAndView mv = new ModelAndView();
		
		// 수정
		requestService.updateRequest(request);

		mv.addObject("request", request);
		mv.setViewName("redirect:/manage/request");
		return mv;
	}
	
	
	// 도서 관리
	@RequestMapping("/books")
	public ModelAndView bookList(BookVo bookVo) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
        //도서 목록 
		List<BookVo> bookList = bookService.getBookList(bookVo);
		
		mv.addObject("bookList",bookList);
		
		mv.addObject("manageMenu", manageMenu);
		mv.setViewName("manage/books/bookList");
		return mv;
	}
	
	//도서 등록
	@RequestMapping("book/writeForm")
	public ModelAndView bookWriteForm(String postCategory) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("postCategory", postCategory);
		mv.setViewName("manage/books/bookwrite");
		
		return mv;
		
		
		
	}
	 
	@RequestMapping("/book/write")
	public ModelAndView bookWrite(BookVo bookVo) {
		ModelAndView mv = new ModelAndView();
		
		bookService.insertBook(bookVo);	
		
		mv.addObject("book", bookVo);
		mv.setViewName("redirect:/manage/books");
		return mv;
	
	}
	
	
	
	//도서 수정
	@RequestMapping("book/updateForm")
	public ModelAndView bookUpdateForm(int bookkey, String postCategory) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
				
				
		//내용 가져오기
	    BookVo bookVo = bookService.getBook(bookkey);
	    
	    mv.addObject("manageMenu", manageMenu);
	    mv.addObject("book", bookVo);
	    mv.setViewName("manage/books/bookupdate");
		return mv;
		
		
	}
	@RequestMapping("/book/update")
	public ModelAndView bookUpateForm(BookVo bookVo) {
		
		
		bookService.updateBook(bookVo);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("book", bookVo);
		mv.setViewName("redirect:/manage/books");
		
		return mv;
		
	}
	
	
	//도서 삭제
	@RequestMapping("/book/delete")
	public ModelAndView bookDelete(int bookkey,String postCategory) {
		ModelAndView mv =new ModelAndView();
		
		bookService.deleteBook(bookkey);
		
		mv.addObject("bookkey",bookkey);
		mv.setViewName("redirect:/manage/books");
		return mv;
	}
	
}
