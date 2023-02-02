package com.ebook.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.board.dao.BoardDao;
import com.ebook.board.service.BoardService;
import com.ebook.board.vo.BoardVo;
import com.ebook.board.vo.CommentVo;
import com.ebook.manage.vo.RequestVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	// 목록
	@Override
	public List<BoardVo> getBoardList(String postCategory) {
		List<BoardVo> boardList = boardDao.getBoardList(postCategory);
		return boardList;
	}
	
	// 보기
	@Override
	public BoardVo getBoardView(int postKey) {
		BoardVo board = boardDao.getBoardView(postKey);
		return board;
	}
	
	// 작성
	@Override
	public void insertBoard(BoardVo board) {
		boardDao.insertBoard(board);
	}
	
	// 정보 보기
	@Override
	public BoardVo getBoard(int postKey) {
		BoardVo board = boardDao.getBoard(postKey);
		return board;
	}
	
	// 수정
	@Override
	public void updateBoard(BoardVo board) {
		boardDao.updateBoard(board);
	}
	
	// 삭제
	@Override
	public void deleteBoard(int postKey) {
		boardDao.deleteBoard(postKey);
	}
	
	
	/* ------------------------------------------------------------ */
	
	
	// 댓글 목록
	@Override
	public List<CommentVo> getCommList(int postKey) {
		List<CommentVo> commList = boardDao.getCommList(postKey);
		return commList;
	}
	
	// 댓글 작성
	@Override
	public void insertComment(CommentVo comm) {
		boardDao.insertComment(comm);
	}
	
	// 댓글 가져오기
	@Override
	public CommentVo getComment(int commIdx) {
		CommentVo comm = boardDao.getComment(commIdx);
		return comm;
	}
	
	// 댓글 수정
	@Override
	public void updateComment(CommentVo comm) {
		boardDao.updateComment(comm);
	}
	
	// 댓글 삭제
	@Override
	public void deleteComment(int commIdx) {
		boardDao.deleteComment(commIdx);
		
	}
	
	
	/* ------------------------------------------------------------ */
	
	
	// 도서 요청 목록
	@Override
	public List<RequestVo> getRequestList(String postCategory) {
		List<RequestVo> requestList = boardDao.getRequestList(postCategory);
		return requestList;
	}
	
	// 도서 요청 작성
	@Override
	public void insertBookRequest(RequestVo request) {
		boardDao.insertBookRequest(request);
		
	}
	
	// 도서 요청 삭제
	@Override
	public void deleteBookRequest(int req_key) {
		boardDao.deleteBookRequest(req_key);
		
	}
	
	
	/* ------------------------------------------------------------ */
	
	
	// Q&A 답글
	@Override
	public void insertReplayBoard(BoardVo board) {
		boardDao.insertReplayBoard(board);
		
	}


}
