package com.ebook.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebook.board.dao.BoardDao;
import com.ebook.board.vo.BoardVo;
import com.ebook.board.vo.CommentVo;
import com.ebook.manage.vo.RequestVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 목록
	@Override
	public List<BoardVo> getBoardList(String postCategory) {
		List<BoardVo> boardList = sqlSession.selectList("Board.BoardList", postCategory);
		return boardList;
	}
	
	// 보기
	@Override
	public BoardVo getBoardView(int postKey) {
		// 조회수 증가
		sqlSession.update("Board.ReadCountUpdate", postKey );
		
		BoardVo board = sqlSession.selectOne("Board.BoardView", postKey);
		return board;
	}
	
	// 작성
	@Override
	public void insertBoard(BoardVo board) {
		sqlSession.insert("Board.BoardInsert", board);
	}
	
	// 정보 가져오기
	@Override
	public BoardVo getBoard(int postKey) {
		BoardVo board = sqlSession.selectOne("Board.BoardView", postKey);
		return board;
	}
	
	// 수정
	@Override
	public void updateBoard(BoardVo board) {
		sqlSession.update("Board.BoardUpdate", board);
	}
	
	// 삭제
	@Override
	public void deleteBoard(int postKey) {
		sqlSession.delete("Board.BoardDelete", postKey);
	}
	
	
	/*----------------------------------------*/

	
	// 댓글 목록
	@Override
	public List<CommentVo> getCommList(int postKey) {
		List<CommentVo> commList = sqlSession.selectList("Board.CommentList", postKey);
		return commList;
	}
	
	// 댓글 작성
	@Override
	public void insertComment(CommentVo comm) {
		sqlSession.insert("Board.CommentInsert", comm);
	}
	
	// 댓글 정보 가져오기
	@Override
	public CommentVo getComment(int commIdx) {
		CommentVo comm = sqlSession.selectOne("Board.Comment", commIdx);
		return comm;
	}
	
	// 댓글 수정
	@Override
	public void updateComment(CommentVo comm) {
		sqlSession.update("Board.CommentUpdate", comm);
	}

	// 댓글 삭제
	@Override
	public void deleteComment(int commIdx) {
		sqlSession.delete("Board.CommentDelete", commIdx);
	}
	
	
	/*----------------------------------------*/

	
	// 도서 요청 목록
	@Override
	public List<RequestVo> getRequestList(String postCategory) {
		List<RequestVo> requestList = sqlSession.selectList("Board.BooKRequestList", postCategory);
		return requestList;
	}
	
	// 도서 요청 작성
	@Override
	public void insertBookRequest(RequestVo request) {
		sqlSession.insert("Board.BooKRequestInsert", request);
		
	}
	
	// 도서 요청 삭제
	@Override
	public void deleteBookRequest(int req_key) {
		sqlSession.delete("Board.BookRequestDelete", req_key);
		
	}
	
	
	/*----------------------------------------*/
	
	// Q&A 답글
	@Override
	public void insertReplayBoard(BoardVo board) {
		sqlSession.insert("Board.ReplayBoardInsert", board);
		
	}
	


}
