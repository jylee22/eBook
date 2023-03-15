package com.ebook.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.manage.dao.RequestDao;
import com.ebook.manage.service.RequestService;
import com.ebook.manage.vo.RequestVo;

@Service("requestService")
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestDao requestDao;
	
	@Override
	public List<RequestVo> getRequestList() {
		List<RequestVo> requestList = requestDao.getRequestList();
		return requestList;
	}

	@Override
	public RequestVo getRequestView(int req_key) {
		RequestVo request = requestDao.getRequestView(req_key);
		return request;
	}
	
	
	@Override
	public RequestVo getRequest(int req_key) {
		RequestVo request = requestDao.getRequest(req_key);
		return request;
	}


	@Override
	public void updateRequest(RequestVo request) {
		requestDao.updateRequest(request);
		
	}
	
	// 게시판 : 도서 요청 > 목록
	@Override
	public List<RequestVo> getRequestList(String postCategory) {
		List<RequestVo> requestList = requestDao.getRequestList(postCategory);
		return requestList;
	}
	
	// 게시판 : 도서 요청 > 작성
	@Override
	public void insertRequestWrite(RequestVo board) {
		requestDao.insertRequestWrite(board);
		
	}



}
