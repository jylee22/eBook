package com.ebook.subscr.controller;

import com.ebook.user.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ebook.subscr.service.SubscribeService;
import com.ebook.subscr.vo.SubscrVo;

import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Log4j2
@Controller
public class SubscrController {

	@Autowired
	private SubscribeService subscribeService;
	HttpSession httpSession;
	// 구독신청

	@GetMapping("/subscr/writeForm")
	public String subscrWrite(Model model, HttpSession session) {
		UsersVO userinfo = (UsersVO) session.getAttribute("user");
		if (userinfo==null){
			return "redirect:/";
		}
		String userId = userinfo.getUserId();
		model.addAttribute("userId",userId);

		return "/subscr/writeForm";
	}
	
	@PostMapping("/subscr/writeForm")
	public String subResister(SubscrVo subscrVo) throws Exception{
		
		subscribeService.insertSubscr(subscrVo);

		return "redirect:/subscr/subscrView";
	}

	
	@GetMapping("/subscr/subscrView")
	public String go(HttpSession session,Model model) throws Exception{
		UsersVO userinfo = (UsersVO) session.getAttribute("user");
		if (userinfo==null){
			return "redirect:/";
		}
		log.info(userinfo);
		String userId = userinfo.getUserId();
		SubscrVo modelinfo = subscribeService.getSubscrView(userId);
		log.info(modelinfo);
		model.addAttribute("info",modelinfo);
		return "/subscr/subscrView";
	}
//	@PostMapping("/subscr/subscrView")
//	public String subView(HttpSession httpSession, Model model) throws Exception{
//		UsersVO userinfo = (UsersVO) httpSession.getAttribute("user");
//		log.info(userinfo);
//		String userId = userinfo.getUserId();
//		SubscrVo modelinfo = subscribeService.getSubscrView(userId);
//		log.info(modelinfo);
//		model.addAttribute("info",modelinfo);
//
//		return "/subscr/subscrView";
//	}
}
