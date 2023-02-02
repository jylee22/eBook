package com.ebook.manage.dao;

import java.util.List;

import com.ebook.manage.vo.RequestVo;

public interface RequestDao {

	List<RequestVo> getRequestList();

	RequestVo getRequestView(int req_key);

	void updateRequest(RequestVo request);

	RequestVo getRequest(int req_key);

	List<RequestVo> getRequestList(String postCategory);

	void insertRequestWrite(RequestVo board);

}
