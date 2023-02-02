package com.ebook.subscr.dao;

import java.util.List;

import com.ebook.subscr.vo.SubscrVo;

public interface SubscrDao {

	List<SubscrVo> getSubscrList();

	SubscrVo getSubscrView(String userId);

	void insertSubscr(SubscrVo subscr);

}
