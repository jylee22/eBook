package com.ebook.manage.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebook.manage.dao.RequestDao;
import com.ebook.manage.vo.RequestVo;

@Repository("requestDao")
public class RequestDaoImpl implements RequestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<RequestVo> getRequestList() {
		List<RequestVo> requestList= sqlSession.selectList("Manage.RequestList");
		return requestList;
	}

	@Override
	public RequestVo getRequestView(int req_key) {
		RequestVo request = sqlSession.selectOne("Manage.RequestView", req_key);
		return request;
	}

	@Override
	public void updateRequest(RequestVo request) {
		sqlSession.update("Manage.RequestUpdate", request);
		
	}

	@Override
	public RequestVo getRequest(int req_key) {
		RequestVo request = sqlSession.selectOne("Manage.Request", req_key);
		return request;
	}
	
	// 게시판 : 도서 요청 > 목록
	@Override
	public List<RequestVo> getRequestList(String postCategory) {
		List<RequestVo> requestList= sqlSession.selectList("Manage.RequestList",postCategory);
		return requestList;
	}
	
	// 게시판 : 도서 요청 > 작성
	@Override
	public void insertRequestWrite(RequestVo board) {
		sqlSession.selectList("Board.RequestInsert",board);
		
	}

}
