package com.ebook.board.controller;

import java.util.HashMap;
import java.util.List;

import ch.qos.logback.classic.Logger;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ebook.board.service.BoardService;
import com.ebook.board.vo.BoardVo;
import com.ebook.board.vo.CommentVo;
import com.ebook.board.vo.PageVo;
import com.ebook.manage.service.MenuService;
import com.ebook.manage.service.RequestService;
import com.ebook.manage.vo.MenuVo;
import com.ebook.manage.vo.RequestVo;


@Log4j2
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping("/list/search")
	public ModelAndView search(@RequestParam String keyWord, @RequestParam String searchValue) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("검색: " + keyWord);
		System.out.println("값 :"  + searchValue);
		
		
		mv.setViewName("board/boardList");	
		return   mv;	
	}
	
	// 목록
	@RequestMapping("/list")
	public ModelAndView BoardList (String postCategory, @RequestParam HashMap<String, Object>	map){
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
	
		// 현재 메뉴 정보
		MenuVo pageMenu = menuService.getPageMenu(postCategory);

		log.info(pageMenu);
		
		// 페이징 : 조회된 결과 pagecount(2개만 return -> 2줄 / Row_number() 로 2개만 조회
		int nowPage    =   Integer.parseInt( map.get("nowPage").toString() );
		int pageCount  =   Integer.parseInt( map.get("pageCount").toString() ); 
		int startNum   =   ( nowPage - 1  ) * pageCount + 1;
	    int endNum     =   nowPage * pageCount; 
	    
	    map.put("startNum",   startNum);
		map.put("endNum",     endNum);
		
		// 목록
		List<PageVo> boardList = boardService.getBoardList(map);
		
		if(postCategory.equals("bookrequest")) {
			// 도서 요청
			List<PageVo> requestList = boardService.getRequestList(map);
			mv.addObject("requestList", requestList);
		}
		
		PageVo page  = (PageVo) map.get("Page");

		
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("pageMenu", pageMenu);
		mv.addObject("page", page);
		mv.addObject("map",map);
		mv.addObject("boardList", boardList);

		mv.addObject("postCategory",postCategory);
		
		mv.setViewName("board/boardList");	
		return   mv;	
	}
	
	// 보기
	@RequestMapping("/view")
	public ModelAndView BoardView(int postKey, String postCategory,
			@RequestParam HashMap<String, Object>	map) {
		ModelAndView mv = new ModelAndView();
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		
		// 현재 메뉴 정보
		MenuVo pageMenu = menuService.getPageMenu(postCategory);
				
		// 게시글 보기
		BoardVo board = boardService.getBoardView(map);
		board.setPostContent(board.getPostContent().replace("\n", "<br>" ));
		
		// 커뮤니티 댓글 목록
		List<CommentVo> commList = boardService.getCommList(map);
		
		// 커뮤니티 댓글 갯수
		CommentVo comm = boardService.getCommentcount(postKey);
				
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("board",board);
		mv.addObject("commList",commList);
		mv.addObject("pageMenu", pageMenu);
		mv.addObject("comm", comm);
		mv.addObject("map", map);
		
		mv.setViewName("/board/boardView");
		return mv;
	}

	// 작성
	@RequestMapping("/writeForm")
	public ModelAndView boardWriteFrom(String postCategory, @RequestParam HashMap<String, Object>	map) {
		ModelAndView mv = new ModelAndView();
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		
		// 현재 메뉴 정보
		MenuVo pageMenu = menuService.getPageMenu(postCategory);
				
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("pageMenu", pageMenu);
		mv.addObject("map", map);
		mv.addObject("postCategory", postCategory);

		mv.setViewName("/board/boardWrite");
		return mv;
	}
	
	// 등록
	@RequestMapping("/write")
	public ModelAndView boardWrite(BoardVo board, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		
		// 작성
		boardService.insertBoard(map);
		
		int  nowPage    = Integer.parseInt( (String) map.get("nowPage") );
		int  pageCount  = Integer.parseInt( (String) map.get("pageCount") );
		int  pageGrpNum = Integer.parseInt( (String) map.get("pageGrpNum") );
	
		mv.addObject("map",  map);
		
		mv.setViewName("redirect:/board/list?postCategory="+ board.getPostCategory() +
				"&nowPage="+ nowPage + "&pageCount="+ pageCount +"&pageGrpNum="+ pageGrpNum);
		return mv;
	}
	
	// 수정
	@RequestMapping("/updateForm")
	public ModelAndView boardUpdateForm(int postKey, String postCategory, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		
		// 정보 가져오기
		BoardVo board = boardService.getBoard(map);
		
		// 현재 메뉴 정보
		MenuVo pageMenu = menuService.getPageMenu(postCategory);
		
		System.out.println("update form board: " + board);
		System.out.println("update form map: " + map);
		
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("board", board);
		mv.addObject("map", map);
		mv.addObject("pageMenu", pageMenu);
		
		System.out.println("map"+map);
		
		mv.setViewName("/board/boardUpdate");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView boardUpdate(BoardVo board, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		
		boardService.updateBoard(map);
		mv.addObject("board", board);
		mv.addObject("map", map);
		
		String  postCategory = (String) map.get("postCategory");
		int  nowPage    = Integer.parseInt( (String) map.get("nowPage") );
		int  pageCount  = Integer.parseInt( (String) map.get("pageCount") );
		int  pageGrpNum = Integer.parseInt( (String) map.get("pageGrpNum") );

		mv.addObject("map",  map);
		
		mv.setViewName("redirect:/board/list?postCategory="+ board.getPostCategory() +
				"&nowPage="+ nowPage + "&pageCount="+ pageCount +"&pageGrpNum="+ pageGrpNum);
		
		return mv;
	}
	
	// 삭제
	@RequestMapping("/delete")
	public ModelAndView boardDelete(int postKey, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		
		boardService.deleteBoard(map);
		//mv.addObject("postCategory", postCategory);
		
		String  postCategory = (String) map.get("postCategory");
		int  nowPage    = Integer.parseInt( (String) map.get("nowPage") );
		int  pageCount  = Integer.parseInt( (String) map.get("pageCount") );
		int  pageGrpNum = Integer.parseInt( (String) map.get("pageGrpNum") );
		
		mv.addObject("map", map);
		
		mv.setViewName("redirect:/board/list?postCategory="+ postCategory +
				"&nowPage="+ nowPage + "&pageCount="+ pageCount +"&pageGrpNum="+ pageGrpNum);
	
		return mv;
	}
	
	
	/* ------------------------------------------------------------ */
	
	
	// qna 답글
	@RequestMapping("/replayForm")
	public ModelAndView qnaWriteFrom(int postKey) {
		ModelAndView mv = new ModelAndView();
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		
		// 게시글 보기
		//BoardVo board = boardService.getBoardView(postKey);
		//board.setPostContent(board.getPostContent().replace("\n", "<br>" ));
		
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		//mv.addObject("board", board);
		
		
		mv.setViewName("/board/qna/qnaWrite");
		return mv;
		
	}
	
	// qna 답글쓰기
	@RequestMapping("/replay")
	public ModelAndView qnaWrite(BoardVo board) {
		ModelAndView mv = new ModelAndView();

		boardService.insertReplayBoard(board);

		mv.addObject("board", board);
		
		mv.setViewName("redirect:/board/list?postCategory=" + board.getPostCategory() );
		return mv;
		
	}
	
	// qna 답글쓰기 수정
	@RequestMapping("/replayUpdate")
	public ModelAndView qnaUpdate(BoardVo board) {
		ModelAndView mv = new ModelAndView();

		//boardService.insertReplayBoard(board);

		mv.addObject("board", board);
		
		mv.setViewName("redirect:/board/list?postCategory=" + board.getPostCategory() );
		return mv;
		
	}
	
	/* ------------------------------------------------------------ */
	
	
	// 도서 요청 : 작성
	@RequestMapping("/list/requestWrite")
	public ModelAndView insertBookRequest(RequestVo request, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		
		boardService.insertBookRequest(map);
		
		mv.addObject("request",request);
		mv.addObject("map",map);

		String  postCategory = (String) map.get("postCategory");
		int  nowPage    = Integer.parseInt( (String) map.get("nowPage") );
		int  pageCount  = Integer.parseInt( (String) map.get("pageCount") );
		int  pageGrpNum = Integer.parseInt( (String) map.get("pageGrpNum") );

		mv.setViewName("redirect:/board/list?postCategory="+ postCategory +
				"&nowPage="+ nowPage + "&pageCount="+ pageCount +"&pageGrpNum="+ pageGrpNum);
		return mv;
	}
	
	// 도서 요청 : 작성
	@RequestMapping("/list/delete")
	public ModelAndView daelteBookRequest(@RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		
		boardService.deleteBookRequest(map);

		String  postCategory = (String) map.get("postCategory");
		int  nowPage    = Integer.parseInt( (String) map.get("nowPage") );
		int  pageCount  = Integer.parseInt( (String) map.get("pageCount") );
		int  pageGrpNum = Integer.parseInt( (String) map.get("pageGrpNum") );
		
		mv.addObject("map", map);
		
		mv.setViewName("redirect:/board/list?postCategory="+ postCategory +
				"&nowPage="+ nowPage + "&pageCount="+ pageCount +"&pageGrpNum="+ pageGrpNum);

		return mv;
	}
	
	
	/* ------------------------------------------------------------ */

	
	// 댓글 작성
	@RequestMapping("/view/comment")
	public ModelAndView comment(int postKey, CommentVo comm, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();

		// 커뮤니티 댓글 작성
		boardService.insertComment(map);

		mv.addObject("comm",comm);
		mv.addObject("map",map);
		
		String  postCategory = (String) map.get("postCategory");
		int  nowPage    = Integer.parseInt( (String) map.get("nowPage") );
		int  pageCount  = Integer.parseInt( (String) map.get("pageCount") );
		int  pageGrpNum = Integer.parseInt( (String) map.get("pageGrpNum") );
		
		mv.addObject("map", map);
		
		mv.setViewName("redirect:/board/view?postCategory="+ postCategory + "&postKey=" + postKey +
				"&nowPage="+ nowPage + "&pageCount="+ pageCount +"&pageGrpNum="+ pageGrpNum);

		return mv;
	}
	
	// 댓글 정보 가져오기
	@RequestMapping("/view/commUpdateForm")
	public ModelAndView commentUpdateForm(int commIdx, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		
		// 정보 가져오기
		CommentVo comm = boardService.getComment(commIdx);
		mv.addObject("comm", comm);
		mv.addObject("map", map);
		
		mv.setViewName("/board/comm/commentUpdate");
		return mv;
	}
	
	// 댓글 수정
	@RequestMapping("/view/commUpdate")
	public ModelAndView commentUpdate(CommentVo comm, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		
		boardService.updateComment(map);
		mv.addObject("comm", comm);
		mv.addObject("map", map);
		
		String  postCategory = (String) map.get("postCategory");
		int  nowPage    = Integer.parseInt( (String) map.get("nowPage") );
		int  pageCount  = Integer.parseInt( (String) map.get("pageCount") );
		int  pageGrpNum = Integer.parseInt( (String) map.get("pageGrpNum") );
		
		mv.addObject("map", map);
		
		mv.setViewName("redirect:/board/view?postCategory="+ postCategory + "&postKey=" + comm.getPostKey() +
				"&nowPage="+ nowPage + "&pageCount="+ pageCount +"&pageGrpNum="+ pageGrpNum);
		return mv;
	}
	
	// 댓글 삭제
	@RequestMapping("/view/delete")
	public ModelAndView commentDelete(CommentVo comm, @RequestParam  HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();

		boardService.deleteComment(map);
		mv.addObject("comm",comm);
		mv.addObject("map",map);
		
		String  postCategory = (String) map.get("postCategory");
		int  nowPage    = Integer.parseInt( (String) map.get("nowPage") );
		int  pageCount  = Integer.parseInt( (String) map.get("pageCount") );
		int  pageGrpNum = Integer.parseInt( (String) map.get("pageGrpNum") );
		
		mv.setViewName("redirect:/board/view?postCategory="+ postCategory + "&postKey=" + comm.getPostKey() +
				"&nowPage="+ nowPage + "&pageCount="+ pageCount +"&pageGrpNum="+ pageGrpNum);
		return mv;
	}
	
}
