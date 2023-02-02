package com.ebook.home.controller;

import java.util.List;

import com.ebook.api.service.ApiService;
import com.ebook.api.vo.ApiDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ebook.board.service.BoardService;
import com.ebook.manage.service.MenuService;
import com.ebook.manage.vo.MenuVo;
@Log4j2
@Controller
public class HomeController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private ApiService apiService;

	@RequestMapping("/")
	public ModelAndView home(ApiDTO apiDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		List<ApiDTO> random = apiService.getRandomList(apiDTO);
		log.info(random.get(0).getImage());
		log.info("=====================================");
		mv.addObject("random",random);
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		
		mv.setViewName("home");
		return mv;
	}
}
