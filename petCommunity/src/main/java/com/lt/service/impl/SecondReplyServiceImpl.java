package com.lt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.ISecondReplyDao;
import com.lt.pojo.SecondReply;
import com.lt.service.ISecondReplyService;

@Service
public class SecondReplyServiceImpl implements ISecondReplyService {

	@Autowired
	private ISecondReplyDao secondReplyDao;
	
	@Override
	public List<SecondReply> selectAllSecondReplies() {
		return secondReplyDao.selectAllSecondReplies();
	}

	@Override
	public SecondReply selectSecondReplyById(Integer sId) {
		return secondReplyDao.selectByPrimaryKey(sId);
	}

	@Override
	public List<SecondReply> selectSecondReplyByFirstReplyId(Integer fId) {
		return secondReplyDao.selectAllSecondRepliesByFirstReply(fId);
	}

	@Override
	public List<SecondReply> selectSecondReplyByUserId(Integer uId) {
		return secondReplyDao.selectAllSecondRepliesByUserId(uId);
	}

	@Override
	public int insertSecondReply(SecondReply secondReply) {
	    int i = secondReplyDao.insert(secondReply);
		return i;
	}

	@Override
	public int updateSecondReply(SecondReply secondReply) {
		int i = secondReplyDao.updateByPrimaryKeySelective(secondReply);
		return  i;
	}

	@Override
	public int deleteSecondReply(Integer sId) {
		int i = secondReplyDao.deleteByPrimaryKey(sId);
		return i;
	}

	@Override
	public int deleteSecondReplyByFirstReply(Integer fId) {
		int i = secondReplyDao.deleteByFirstReply(fId);
		return i;
	}

	@Override
	public int deleteSecondReplyByUser(Integer uId) {
		int i = secondReplyDao.deleteByUserId(uId);
		return i;
	}

}
