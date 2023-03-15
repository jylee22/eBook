package com.ebook.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebook.board.dao.BoardDao;
import com.ebook.board.vo.BoardVo;
import com.ebook.board.vo.CommentVo;
import com.ebook.board.vo.PageVo;
import com.ebook.manage.vo.RequestVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 목록 페이징
	@Override
	public List<PageVo> getBoardList(HashMap<String, Object> map) {
		System.out.println("DAO Paging " + map);
		
		int totalCount = sqlSession.selectOne("Board.BoardCount", map);
		map.put( "totalCount", totalCount);
		
		List<PageVo>  boardList =  sqlSession.selectList("Board.BoardPageList", map);
		return boardList;
	}

	// 보기
	@Override
	public BoardVo getBoardView(HashMap<String, Object> map) {
		// 조회수 증가
		sqlSession.update("Board.ReadCountUpdate", map );
		
		BoardVo board = sqlSession.selectOne("Board.BoardView", map);
		return board;
	}

	// 작성
	@Override
	public void insertBoard(HashMap<String, Object> map) {
		sqlSession.insert("Board.BoardInsert", map);
	}

	// 정보 가져오기
	@Override
	public BoardVo getBoard(HashMap<String, Object> map) {
		BoardVo board = sqlSession.selectOne("Board.BoardView", map);
		return board;
	}

	// 수정
	@Override
	public void updateBoard(HashMap<String, Object> map) {
		sqlSession.update("Board.BoardUpdate", map);
	}

	
	// 삭제
	@Override
	public void deleteBoard(HashMap<String, Object> map) {
		sqlSession.delete("Board.BoardDelete", map);		
	}

	
	/*----------------------------------------*/

	
	// 댓글 목록
	@Override
	public List<CommentVo> getCommList(HashMap<String, Object> map) {
		List<CommentVo> commList = sqlSession.selectList("Board.CommentList", map);
		return commList;
	}
	
	// 댓글 작성
	@Override
	public void insertComment(HashMap<String, Object> map) {
		sqlSession.insert("Board.CommentInsert", map);
		
	}
	
	// 댓글 정보 가져오기
	@Override
	public CommentVo getComment(int commIdx) {
		CommentVo comm = sqlSession.selectOne("Board.Comment", commIdx);
		return comm;
	}
	
	// 댓글 수정
	@Override
	public void updateComment(HashMap<String, Object> map) {
		sqlSession.update("Board.CommentUpdate", map);
	}

	// 댓글 삭제
	@Override
	public void deleteComment(HashMap<String, Object> map) {
		sqlSession.delete("Board.CommentDelete", map);
		
	}
	
	// 댓글 갯수
	@Override
	public CommentVo getCommentcount(int postKey) {
		CommentVo comm = sqlSession.selectOne("Board.CommentCount", postKey);
		return comm;
	}
	
	
	/*----------------------------------------*/

	
	// 도서 요청 목록
	@Override
	public List<PageVo> getRequestList(HashMap<String, Object> map) {
		int totalCount = sqlSession.selectOne("Board.BooKRequestCount", map);
		map.put( "totalCount", totalCount);
		
		List<PageVo> requestList = sqlSession.selectList("Board.BooKRequestList", map);
		return requestList;
	}
	
	// 도서 요청 작성
	@Override
	public void insertBookRequest(HashMap<String, Object> map) {
		sqlSession.insert("Board.BooKRequestInsert", map);
	}


	
	// 도서 요청 삭제
	@Override
	public void deleteBookRequest(HashMap<String, Object> map) {
		sqlSession.delete("Board.BookRequestDelete", map);
		
	}
	
	/*----------------------------------------*/
	
	
	// Q&A 답글
	@Override
	public void insertReplayBoard(BoardVo board) {
		sqlSession.insert("Board.ReplayBoardInsert", board);
		
	}





}
