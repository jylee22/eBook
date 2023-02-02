package com.ebook.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.manage.dao.MenuDao;
import com.ebook.manage.service.MenuService;
import com.ebook.manage.vo.MenuVo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<MenuVo> getMenuList() {
		List<MenuVo> menuList = menuDao.getMenuList();
		return menuList;
	}
	
	// 사이드 메뉴
	@Override
	public List<MenuVo> getManageMenu() {
		List<MenuVo> manageMenu = menuDao.getManageMenu();
		return manageMenu;
	}

	@Override
	public List<MenuVo> getBoardMenu() {
		List<MenuVo> boardMenu = menuDao.getBoardMenu();
		return boardMenu;
	}

	@Override
	public List<MenuVo> getMyMenu() {
		List<MenuVo> myMenu = menuDao.getMyMenu();
		return myMenu;
	}
	
	// 메뉴 정보 보기
	@Override
	public MenuVo getMenu(int menu_seq) {
		MenuVo  menu  =  menuDao.getMenu( menu_seq );
		return menu;
	}
	
	// 메뉴 생성
	@Override
	public void insertMenu(MenuVo menu) {
		menuDao.insertMenu(menu);
	}
	
	// 메뉴 수정
	@Override
	public void updateMenu(MenuVo menu) {
		menuDao.updateMenu(menu);
	}
	
	// 현재 메뉴 가져오기
	@Override
	public MenuVo getPageMenu(String postCategory) {
		MenuVo pageMenu = menuDao.getPageMenu(postCategory);
		return pageMenu;
	}
	

	

}
