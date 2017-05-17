package com.lt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.IFirstReplyDao;
import com.lt.pojo.FirstReply;
import com.lt.service.IFirstReplyService;

@Service
public class FirstReplyServiceImpl implements IFirstReplyService {

	@Autowired
	private IFirstReplyDao firstReplyDao;
	
	@Override
	public List<FirstReply> selectAllFirstReplies() {
		return firstReplyDao.selectAllFirstReplies();
	}

	@Override
	public FirstReply selectFirstReply(Integer fid) {
		return firstReplyDao.selectByPrimaryKey(fid);
	}

	@Override
	public List<FirstReply> selectFirstReplyByPostId(Integer pId) {
		return firstReplyDao.selectAllFirstRepliesByPostId(pId);
	}

	@Override
	public List<FirstReply> selectFirstReplyByUserId(Integer uId) {
		return firstReplyDao.selectAllFirstRepliesByUserId(uId);
	}

	@Override
	public int insertFirstReply(FirstReply firstReply) {
		int i = firstReplyDao.insert(firstReply);
		return i ;
	}

	@Override
	public int updateFirstReply(FirstReply firstReply) {
		int i = firstReplyDao.updateByPrimaryKeySelective(firstReply);
		return i;
	}

	@Override
	public int deleteFirstReply(Integer fid) {
	    int i = firstReplyDao.deleteByPrimaryKey(fid);
		return i;
	}

	@Override
	public int deleteFirstReplyByPostId(Integer pId) {
	    int i = firstReplyDao.deleteByPostId(pId);
		return i ;
	}

	@Override
	public int deleteFirstReplyByUserId(Integer uid) {
		int i = firstReplyDao.deleteByUserId(uid);
		return i;
	}

}
