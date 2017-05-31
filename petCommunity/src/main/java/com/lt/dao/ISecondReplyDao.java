package com.lt.dao;

import java.util.List;

import com.lt.pojo.SecondReply;

public interface ISecondReplyDao {
	
	List<SecondReply> selectAllSecondReplies();
	
	List<SecondReply> selectAllSecondRepliesByFirstReply(String firstreplyid);
	
	List<SecondReply> selectAllSecondRepliesByUserId(String userid);
	
    int deleteByPrimaryKey(String secondreplyid);
    
    int deleteByUserId(String userid);

    int insert(SecondReply record);

    int insertSelective(SecondReply record);

    SecondReply selectByPrimaryKey(String secondreplyid);

    int updateByPrimaryKeySelective(SecondReply record);

    int updateByPrimaryKey(SecondReply record);
    
    int deleteByFirstReply(String firstreplyid);
}