package com.ebook.user.controller;


import com.ebook.user.service.UsersService;
import com.ebook.user.vo.UsersVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Log4j2
@Controller
public class UsersController {

    @Autowired
    UsersService usersService;
    HttpSession httpSession;

    //==========================로그인 시작==============================
    @GetMapping("/user/login")
    public void login() {
    }

    @PostMapping("/user/login")
    public String login(UsersVO usersVO, HttpSession session) throws Exception {
        log.info(usersVO);
        log.info("post login");
        usersVO = usersService.login(usersVO);
        log.info(usersVO);
        if (usersVO != null) {
            session.setAttribute("user", usersVO);
            log.info(session);

        } else {
            return "redirect:../error";
        }
        log.info(session);
        return "redirect:/";
    }

//==========================로그인 끝===================================


    //=================================회원가입 시작=============================
    @ResponseBody
    @PostMapping(value = "/user/register")
    public String postResister(@Valid UsersVO usersVO, BindingResult bindingResult) throws Exception {
        int result = usersService.idcheck(usersVO);
        try {
            if (result == 1) {
                return "/user/register";
            } else if (result == 0) {
                usersService.register(usersVO);
            }
            // 요기에서~ 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기
            // 존재하지 않는다면 -> register
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return "redirect:/";
    }


//=================================회원가입 끝=============================


    //==========================로그아웃======================================
    @GetMapping("/user/logout")
    public void loggout() throws Exception {
    }

    @PostMapping("/user/logout")
    public String logout(UsersVO usersVO, HttpSession session) throws Exception {


        return "user/logout";
    }
//==========================로그아웃  끝======================================


    //==========================업데이트==========================================
    @GetMapping("/user/update")
    public String update(HttpSession session) {
        UsersVO list = (UsersVO) session.getAttribute("user");
        if (list == null) {
            return "redirect:/";


        }
        return "/user/update";
    }


    @PostMapping("/user/userupdate")
    public String update(UsersVO usersVO, HttpSession httpSession) throws Exception {

        usersService.update(usersVO);

        httpSession.invalidate();

        return "redirect:/";

    }

    //==========================업데이트 끝==========================================
    @GetMapping("/user/delete")
    public String deleteview() throws Exception {
        UsersVO list = (UsersVO) httpSession.getAttribute("user");
        if (list == null) {
            return "redirect:/";
        }
        return "/user/delete";
    }


    //==========================회원탈퇴==========================================
    @PostMapping("/user/userdelete")
    public String delete(UsersVO usersVO, HttpSession httpSession, RedirectAttributes rttr) throws Exception {

        UsersVO user = (UsersVO) httpSession.getAttribute("user");
        //세션에 있는 비밀번호
        String sessionPass = user.getUserPass();
        //vo로 들어오는 비밀번호
        String voPass = usersVO.getUserPass();

        if (!(sessionPass.equals(voPass))) {
            rttr.addFlashAttribute("msg", false);
            return "redirect:/user/update";
        }

        usersService.delete(usersVO);

        httpSession.invalidate();

        return "redirect:/";
    }
//==========================회원탈퇴 끝==========================================


    @PostMapping("/user/idcheck")
    @ResponseBody
    public int idcheck(UsersVO usersVO) throws Exception {
        log.info(usersVO);
        int result = usersService.idcheck(usersVO);
        log.info("=====================");
        log.info(result);
        return result;
    }
}

