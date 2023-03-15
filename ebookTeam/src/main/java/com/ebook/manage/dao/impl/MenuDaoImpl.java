package com.ebook.manage.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebook.manage.dao.MenuDao;
import com.ebook.manage.vo.MenuVo;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MenuVo> getMenuList() {
		List<MenuVo> menuList = sqlSession.selectList("Manage.MenuList");
		return menuList;
	}
	
	// 사이드 메뉴
	@Override
	public List<MenuVo> getManageMenu() {
		List<MenuVo> manageMenu = sqlSession.selectList("Manage.ManageMenu");
		return manageMenu;
	}

	@Override
	public List<MenuVo> getBoardMenu() {
		List<MenuVo> boardMenu = sqlSession.selectList("Manage.BoardMenu");
		return boardMenu;
	}

	@Override
	public List<MenuVo> getMyMenu() {
		List<MenuVo> myMenu = sqlSession.selectList("Manage.MyMenu");
		return myMenu;
	}
	
	// 메뉴 정보 보기
	@Override
	public MenuVo getMenu(int menu_seq) {
		MenuVo   menu  =  sqlSession.selectOne("Manage.Menu", menu_seq);
		return   menu;
	}
	
	// 메뉴 생성
	@Override
	public void insertMenu(MenuVo menu) {
		sqlSession.insert("Manage.MenuInsert", menu);
		
	}
	
	// 메뉴 수정
	@Override
	public void updateMenu(MenuVo menu) {
		sqlSession.update("Manage.MenuUpdate", menu);
		
	}
	
	// 메뉴 삭제
	
	// 현재 메뉴 가져오기
	@Override
	public MenuVo getPageMenu(String postCategory) {
		MenuVo pageMenu = sqlSession.selectOne("Manage.PageMenu", postCategory);
		return pageMenu;
	}
}
