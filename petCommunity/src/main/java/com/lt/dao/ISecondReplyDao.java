package com.lt.dao;

import java.util.List;

import com.lt.pojo.SecondReply;

public interface ISecondReplyDao {
	
	List<SecondReply> selectAllSecondReplies();
	
	List<SecondReply> selectAllSecondRepliesByFirstReply(Integer firstreplyid);
	
	List<SecondReply> selectAllSecondRepliesByUserId(Integer userid);
	
    int deleteByPrimaryKey(Integer secondreplyid);
    
    int deleteByUserId(Integer userid);

    int insert(SecondReply record);

    int insertSelective(SecondReply record);

    SecondReply selectByPrimaryKey(Integer secondreplyid);

    int updateByPrimaryKeySelective(SecondReply record);

    int updateByPrimaryKey(SecondReply record);
    
    int deleteByFirstReply(Integer firstreplyid);
}