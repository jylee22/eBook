package com.ebook.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ebook.manage.service.MenuService;
import com.ebook.manage.service.RequestService;
import com.ebook.subscr.service.SubscribeService;
import com.ebook.manage.service.UserService;
import com.ebook.manage.vo.MenuVo;
import com.ebook.manage.vo.RequestVo;
import com.ebook.subscr.vo.SubscrVo;
import com.ebook.manage.vo.UserVo;

@Controller()
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
			
	// 회원관리
	@RequestMapping("/user")
	public ModelAndView userList() {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();
		
		// 회원 목록
		List<UserVo> userList = userService.getUserList();
		
		mv.addObject("manageMenu", manageMenu);
		mv.addObject("userList", userList);
		
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
	public ModelAndView bookList() {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> manageMenu = menuService.getManageMenu();

		mv.addObject("manageMenu", manageMenu);
		mv.setViewName("manage/books/bookList");
		return mv;
	}
}
