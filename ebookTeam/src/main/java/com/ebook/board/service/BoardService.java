package com.ebook.board.service;

import java.util.HashMap;
import java.util.List;

import com.ebook.board.vo.BoardVo;
import com.ebook.board.vo.CommentVo;
import com.ebook.board.vo.PageVo;
import com.ebook.manage.vo.RequestVo;

public interface BoardService {

	// 목록
	List<PageVo> getBoardList(HashMap<String, Object> map);
	
	// 보기
	BoardVo getBoardView(HashMap<String, Object> map);
	
	// 작성
	void insertBoard(HashMap<String, Object> map);
	
	// 정보 가져오기
	BoardVo getBoard(HashMap<String, Object> map);
	
	// 수정
	void updateBoard(HashMap<String, Object> map);
	
	// 삭제
	void deleteBoard(HashMap<String, Object> map);
	
	/* ------------------------------------------------------------ */
	
	// 댓글 목록
	List<CommentVo> getCommList(HashMap<String, Object> map);
	
	// 댓글 작성
	void insertComment(HashMap<String, Object> map);

	// 댓글 정보 가져오기
	CommentVo getComment(int commIdx);

	// 댓글 수정
	void updateComment(HashMap<String, Object> map);
	
	// 댓글 삭제
	void deleteComment(HashMap<String, Object> map);
	
	// 댓글 갯수
	CommentVo getCommentcount(int postKey);

	/* ------------------------------------------------------------ */
	
	// 도서 요청 목록
	List<PageVo> getRequestList(HashMap<String, Object> map);
	
	// 도서 요청 작성
	void insertBookRequest(HashMap<String, Object> map);
	
	// 도서 요청 삭제
	void deleteBookRequest(HashMap<String, Object> map);
	
	/* ------------------------------------------------------------ */
	
	// qna 답글쓰기
	void insertReplayBoard(BoardVo board);

	














}
