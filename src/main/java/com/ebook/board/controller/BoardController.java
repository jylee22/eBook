package com.ebook.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ebook.board.service.BoardService;
import com.ebook.board.vo.BoardVo;
import com.ebook.board.vo.CommentVo;
import com.ebook.manage.service.MenuService;
import com.ebook.manage.service.RequestService;
import com.ebook.manage.vo.MenuVo;
import com.ebook.manage.vo.RequestVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RequestService requestService;

	// 목록
	@RequestMapping("/list")
	public ModelAndView BoardList(String postCategory) {
		ModelAndView mv = new ModelAndView();
		
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		
		// 목록
		List<BoardVo> boardList = boardService.getBoardList(postCategory);
		
		// 도서 요청
		List<RequestVo> requestList = boardService.getRequestList(postCategory);
		
		// 현재 메뉴 정보
		MenuVo pageMenu = menuService.getPageMenu(postCategory);

		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("boardList", boardList);
		mv.addObject("requestList", requestList);
		mv.addObject("pageMenu", pageMenu);
		mv.addObject("postCategory",postCategory);
		
		mv.setViewName("/board/boardList");
		return mv;
	}
	
	// 보기
	@RequestMapping("/view")
	public ModelAndView BoardView(int postKey, String postCategory) {
		ModelAndView mv = new ModelAndView();
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		
		// 게시글 보기
		BoardVo board = boardService.getBoardView(postKey);
		board.setPostContent(board.getPostContent().replace("\n", "<br>" ));
		
		// 커뮤니티 댓글 목록
		List<CommentVo> commList = boardService.getCommList(postKey);
		
		// 현재 메뉴 정보
		MenuVo pageMenu = menuService.getPageMenu(postCategory);
		
		// 커뮤니티 댓글 갯수
		//CommentVo comm = 
				
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("board",board);
		mv.addObject("commList",commList);
		mv.addObject("pageMenu", pageMenu);
		
		mv.setViewName("/board/boardView");
		return mv;
	}

	// 작성
	@RequestMapping("/writeForm")
	public ModelAndView boardWriteFrom(String postCategory) {
		ModelAndView mv = new ModelAndView();
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		
		// 현재 메뉴 정보
		MenuVo pageMenu = menuService.getPageMenu(postCategory);
				
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("pageMenu", pageMenu);
		mv.addObject("postCategory", postCategory);

		mv.setViewName("/board/boardWrite");
		return mv;
	}
	
	// 등록
	@RequestMapping("/write")
	public ModelAndView boardWrite(BoardVo board) {
		ModelAndView mv = new ModelAndView();
		
		boardService.insertBoard(board);
		mv.addObject("board", board);
		
		mv.setViewName("redirect:/board/list?postCategory="+ board.getPostCategory());
		return mv;
	}
	
	// 수정
	@RequestMapping("/updateForm")
	public ModelAndView boardUpdateForm(int postKey, String postCategory) {
		ModelAndView mv = new ModelAndView();
		// sideMenu
		List<MenuVo> boardMenu = menuService.getBoardMenu();
		List<MenuVo> myMenu = menuService.getMyMenu();
		
		// 정보 가져오기
		BoardVo board = boardService.getBoard(postKey);
		
		// 현재 메뉴 정보
		MenuVo pageMenu = menuService.getPageMenu(postCategory);
		
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("board", board);
		mv.addObject("pageMenu", pageMenu);
		
		mv.setViewName("/board/boardUpdate");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView boardUpdate(BoardVo board) {
		ModelAndView mv = new ModelAndView();
		
		boardService.updateBoard(board);
		mv.addObject("board", board);
		
		mv.setViewName("redirect:/board/list?postCategory=" + board.getPostCategory());
		return mv;
	}
	
	// 삭제
	@RequestMapping("/delete")
	public ModelAndView boardDelete(int postKey, String postCategory) {
		ModelAndView mv = new ModelAndView();
		
		boardService.deleteBoard(postKey);
		mv.addObject("postCategory", postCategory);
		
		mv.setViewName("redirect:/board/list");
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
		BoardVo board = boardService.getBoardView(postKey);
		board.setPostContent(board.getPostContent().replace("\n", "<br>" ));
		
		mv.addObject("boardMenu", boardMenu);
		mv.addObject("myMenu", myMenu);
		mv.addObject("board", board);
		
		
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
	public ModelAndView insertBookRequest(String postCategory, RequestVo request) {
		ModelAndView mv = new ModelAndView();
		
		boardService.insertBookRequest(request);
		
		mv.addObject("request",request);
		mv.addObject("postCategory",postCategory);

		mv.setViewName("redirect:/board/list");
		return mv;
	}
	// 도서 요청 : 작성
	@RequestMapping("/list/delete")
	public ModelAndView daelteBookRequest(String postCategory, int req_key) {
		ModelAndView mv = new ModelAndView();
		
		boardService.deleteBookRequest(req_key);
		
		mv.addObject("postCategory",postCategory);

		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	
	/* ------------------------------------------------------------ */

	
	// 댓글 작성
	@RequestMapping("/view/commForm")
	public ModelAndView commentForm(int postKey) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("postKey", postKey);
		
		mv.setViewName("/board/comm/boardWrite");
		return mv;
	}
	
	@RequestMapping("/view/comment")
	public ModelAndView comment(int postKey, CommentVo comm) {
		ModelAndView mv = new ModelAndView();

		// 커뮤니티 댓글 작성
		boardService.insertComment(comm);
		
		mv.addObject("postKey", postKey);
		mv.addObject("comm",comm);
		
		mv.setViewName("redirect:/board/view/?postCategory=" + comm.getPostCategory());
		return mv;
	}
	
	// 댓글 정보 가져오기
	@RequestMapping("/view/updateForm")
	public ModelAndView commentUpdateForm(int commIdx) {
		ModelAndView mv = new ModelAndView();
		
		// 정보 가져오기
		CommentVo comm = boardService.getComment(commIdx);
		mv.addObject("commIdx", commIdx);
		
		mv.setViewName("/board/comm/boardUpdate");
		return mv;
	}
	
	// 댓글 수정
	@RequestMapping("/view/update")
	public ModelAndView commentUpdate(CommentVo comm) {
		ModelAndView mv = new ModelAndView();
		
		boardService.updateComment(comm);
		mv.addObject("comm", comm);
		
		mv.setViewName("redirect:/board/view/?postCategory=" + comm.getPostCategory() +
				"&postKey" + comm.getPostKey());
		return mv;
	}
	
	// 댓글 삭제
	@RequestMapping("/view/delete")
	public ModelAndView commentDelete(int commIdx, int postKey, String postCategory) {
		ModelAndView mv = new ModelAndView();
		
		boardService.deleteComment(commIdx);
		mv.addObject("postCategory", postCategory);
		mv.addObject("postKey", postKey);
		
		mv.setViewName("redirect:/board/view");
		return mv;
	}

	
}
