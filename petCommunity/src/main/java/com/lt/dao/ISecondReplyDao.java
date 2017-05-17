package com.lt.dao;

import java.util.List;

import com.lt.pojo.SecondReply;

public interface ISecondReplyDao {
	
	List<SecondReply> selectAllSecondReplies();
	
	List<SecondReply> selectAllSecondRepliesByFirstReply(Integer firstreplyid);
	
    int deleteByPrimaryKey(Integer secondreplyid);

    int insert(SecondReply record);

    int insertSelective(SecondReply record);

    SecondReply selectByPrimaryKey(Integer secondreplyid);

    int updateByPrimaryKeySelective(SecondReply record);

    int updateByPrimaryKey(SecondReply record);
    
    int deleteByFirstReply(Integer firstreplyid);
}