package com.ebook.subscr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebook.subscr.vo.SubscrVo;

@Repository("subscrDao")
public class SubscrDaoImpl implements SubscrDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 구독 목록
	@Override
	public List<SubscrVo> getSubscrList() {
		List<SubscrVo> subscrList = sqlSession.selectList("Manage.SubscrList");
		return subscrList;
	}
	
	// 구독 정보
	@Override
	public SubscrVo getSubscrView(String userId) {
		SubscrVo subscr = sqlSession.selectOne("Manage.SubscrView", userId);
		return subscr;
	}
	
	// 구독 신청
	@Override
	public void insertSubscr(SubscrVo subscr) {
		sqlSession.insert("Manage.SubscrInsert", subscr);
		
	}

}
