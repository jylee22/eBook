package com.ebook.board.service;

import java.util.List;

import com.ebook.board.vo.BoardVo;
import com.ebook.board.vo.CommentVo;
import com.ebook.manage.vo.RequestVo;

public interface BoardService {

	// 목록
	List<BoardVo> getBoardList(String postCategory);
	
	// 보기
	BoardVo getBoardView(int postKey);
	
	// 작성
	void insertBoard(BoardVo board);
	
	// 정보 가져오기
	BoardVo getBoard(int postKey);
	
	// 수정
	void updateBoard(BoardVo board);
	
	// 삭제
	void deleteBoard(int postKey);
	
	// 댓글 목록
	List<CommentVo> getCommList(int postKey);
	
	// 댓글 작성
	void insertComment(CommentVo comm);

	// 댓글 정보 가져오기
	CommentVo getComment(int commIdx);

	// 댓글 수정
	void updateComment(CommentVo comm);
	
	// 댓글 삭제
	void deleteComment(int commIdx);
	
	// 도서 요청 목록
	List<RequestVo> getRequestList(String postCategory);
	
	// 도서 요청 작성
	void insertBookRequest(RequestVo request);
	
	// 도서 요청 삭제
	void deleteBookRequest(int req_key);
	
	// qna 답글쓰기
	void insertReplayBoard(BoardVo board);
	

}
