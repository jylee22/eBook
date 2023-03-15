package com.ebook.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.board.dao.BoardDao;
import com.ebook.board.service.BoardService;
import com.ebook.board.vo.BoardVo;
import com.ebook.board.vo.CommentVo;
import com.ebook.board.vo.PageVo;
import com.ebook.manage.vo.RequestVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	// 목록 페이징
	@Override
	public List<PageVo> getBoardList(HashMap<String, Object> map) {
		
		// 조회 : menu_id, nowpage, pagecount
		List<PageVo> boardList = boardDao.getBoardList( map );

		//  화면에 보야질 페이지 번호의 갯수
		int pageTotalCount = 5;  
		
		// 한 페이지에 보여줄 라인수 :조회된 결과 라인수
		int pageCount = Integer.parseInt( 
			String.valueOf(	map.get("pageCount") ) );   // 2
		
		// 현재 페이지 정보 :  nowpage
	    int nowPage    = Integer.parseInt( 
	    	String.valueOf( map.get("nowPage") ) );
		
	    // pagegrpnum : 		
	    int pageGrpNum = Integer.parseInt(
	    		String.valueOf( map.get("pageGrpNum") ) );
		
		// 전체자료수 : totalcount  - 스토어드 프로시져의 out 파라미터 값
		int totalCount = Integer.parseInt(
				String.valueOf( map.get("totalCount") ) );
		
		// 출력할 paging.jsp를 위힌 정보 준비
		BoardPaging     bp  =  new BoardPaging(
				nowPage, pageCount, totalCount, pageTotalCount, pageGrpNum);
		
		PageVo        Page  = bp.getPdsPagingInfo();
		
		Page.setPostCategory( (String) map.get("postCategory") );
		
		map.put("Page", Page);
		
		
		return boardList;
	}
	
	// 보기
	public BoardVo getBoardView(HashMap<String, Object> map) {
		BoardVo board = boardDao.getBoardView(map); 
		return board;
	}

	// 작성
	@Override
	public void insertBoard(HashMap<String, Object> map) {
		boardDao.insertBoard(map);
	}

	// 정보 보기
	@Override
	public BoardVo getBoard(HashMap<String, Object> map) {
		BoardVo board = boardDao.getBoard(map);
		return board;
	}

	// 수정
	@Override
	public void updateBoard(HashMap<String, Object> map) {
		boardDao.updateBoard(map);
		System.out.println("Pds Service setUpdate() map:" + map);
	}
	
	// 삭제
	@Override
	public void deleteBoard(HashMap<String, Object> map) {
		boardDao.deleteBoard(map);
		
	}
	
	
	/* ------------------------------------------------------------ */
	
	
	// 댓글 목록
	@Override
	public List<CommentVo> getCommList(HashMap<String, Object> map) {
		List<CommentVo> commList = boardDao.getCommList(map);
		return commList;
	}

	
	// 댓글 작성
	@Override
	public void insertComment(HashMap<String, Object> map) {
		boardDao.insertComment(map);
		
	}

	
	// 댓글 가져오기
	@Override
	public CommentVo getComment(int commIdx) {
		CommentVo comm = boardDao.getComment(commIdx);
		return comm;
	}
	
	// 댓글 수정
	@Override
	public void updateComment(HashMap<String, Object> map) {
		boardDao.updateComment(map);
	}

	// 댓글 삭제
	@Override
	public void deleteComment(HashMap<String, Object> map) {
		boardDao.deleteComment(map);
		
	}

	// 댓글 갯수
	@Override
	public CommentVo getCommentcount(int postKey) {
		CommentVo comm = boardDao.getCommentcount(postKey);
		return comm;
	}

	
	/* ------------------------------------------------------------ */
	
	
	// 도서 요청 목록
	@Override
	public List<PageVo> getRequestList(HashMap<String, Object> map) {
		List<PageVo> requestList = boardDao.getRequestList(map);
		
		// 페이징
		int pageTotalCount = 2;  
		
		int pageCount = Integer.parseInt( 
			String.valueOf(	map.get("pageCount") ) );   // 2
		
	    int nowPage    = Integer.parseInt( 
	    	String.valueOf( map.get("nowPage") ) );
			
	    int pageGrpNum = Integer.parseInt(
	    		String.valueOf( map.get("pageGrpNum") ) );
		
		int totalCount = Integer.parseInt(
				String.valueOf( map.get("totalCount") ) );
		
		BoardPaging     bp  =  new BoardPaging(
				nowPage, pageCount, totalCount, pageTotalCount, pageGrpNum);
		
		PageVo        Page  = bp.getPdsPagingInfo();
		
		Page.setPostCategory( (String) map.get("postCategory") );
		
		map.put("Page", Page);
		
		return requestList;
	}

	
	// 도서 요청 작성
	@Override
	public void insertBookRequest(HashMap<String, Object> map) {
		boardDao.insertBookRequest(map);
		
	}

	
	// 도서 요청 삭제
	@Override
	public void deleteBookRequest(HashMap<String, Object> map) {
		boardDao.deleteBookRequest(map);
		
	}

	
	/* ------------------------------------------------------------ */
	
	
	// Q&A 답글
	@Override
	public void insertReplayBoard(BoardVo board) {
		boardDao.insertReplayBoard(board);
		
	}




}
