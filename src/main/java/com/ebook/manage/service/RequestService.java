package com.ebook.manage.service;

import java.util.List;

import com.ebook.manage.vo.RequestVo;

public interface RequestService {
	
	// 요청 관리 목록
	List<RequestVo> getRequestList();
	
	// 요청 관리 : 보기
	RequestVo getRequestView(int req_key);
	
	// 요청 관리 : 가져오기
	RequestVo getRequest(int req_key);
	
	// 요청 관리 수정하기
	void updateRequest(RequestVo request);
	
	// 게시판 : 도서 요청 > 목록
	List<RequestVo> getRequestList(String postCategory);
	
	// 게시판 : 도서 요청 > 작성
	void insertRequestWrite(RequestVo board);


}
