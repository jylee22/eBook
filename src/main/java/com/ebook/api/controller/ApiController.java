package com.ebook.api.controller;

import com.ebook.api.service.ApiService;
import com.ebook.api.util.NaverBookSearch;
import com.ebook.api.vo.ApiDTO;
import com.ebook.manage.service.MenuService;
import com.ebook.manage.vo.MenuVo;
import com.ebook.page.Criteria;
import com.ebook.page.PageMaker;
import com.ebook.user.vo.UsersVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class ApiController {
    @Autowired
    HttpSession httpSession;

    private final NaverBookSearch naverBookSearch;
    @Autowired
    private MenuService menuService;
    private final ApiService apiService;

//
//    @GetMapping("/api/search")
//    public String list(ApiDTO apiDTO, Model model) throws Exception {
//        model.addAttribute("list", apiService.list(apiDTO));
//        return "/api/search";
//    }


//    @PostMapping("/api/search")
//    public String getItems(@RequestParam String query) throws Exception {
//        String resultString = naverBookSearch.search(query);
//        List<ApiDTO> bookinfo = naverBookSearch.fromJSONtoItems(resultString);
//
//        for (int i = 0; i < bookinfo.size(); i++) {
//            apiService.insertBook(bookinfo.get(i));
//        }
//
//        return "/api/search";
//    }

    @GetMapping("/api/searchList")
    public String go(Criteria cri, Model model) throws Exception {
//        UsersVO list = (UsersVO) httpSession.getAttribute("user");
        model.addAttribute("list", apiService.list(cri));

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(apiService.listCount());
        List<MenuVo> boardMenu = menuService.getBoardMenu();
        List<MenuVo> myMenu = menuService.getMyMenu();
        model.addAttribute("boardMenu", boardMenu);
        model.addAttribute("myMenu", myMenu);
        model.addAttribute("pageMaker", pageMaker);


            return "/api/searchList";
    }

    @GetMapping("/api/searchList2")
    public String getSearchList(@RequestParam("keyword") String keyword, @RequestParam("type") String type, Model model) throws Exception {
        String resultString = naverBookSearch.search(keyword);
        List<ApiDTO> bookinfo = naverBookSearch.fromJSONtoItems(resultString);
        for (int i = 0; i < bookinfo.size(); i++) {
            apiService.insertBook(bookinfo.get(i));
        }
        ApiDTO dto = new ApiDTO();
        log.info(keyword);
        dto.setKeyword(keyword);
        dto.setType(type);
        log.info(dto);
        List<MenuVo> boardMenu = menuService.getBoardMenu();
        List<MenuVo> myMenu = menuService.getMyMenu();
        model.addAttribute("boardMenu", boardMenu);
        model.addAttribute("myMenu", myMenu);
        System.out.println("=================================");
        model.addAttribute("list", apiService.getSearchList(dto));
        log.info(model);
        return "/api/searchList";


    }


}



