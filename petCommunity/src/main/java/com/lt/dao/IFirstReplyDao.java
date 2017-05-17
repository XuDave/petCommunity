package com.lt.dao;

import java.util.List;

import com.lt.pojo.FirstReply;

public interface IFirstReplyDao {
	
	List<FirstReply> selectAllFirstReplies();
	
	List<FirstReply> selectAllFirstRepliesByPostId(Integer postid);
	
    int deleteByPrimaryKey(Integer firstreplyid);
    
    int deleteByPostId(Integer postid);

    int insert(FirstReply record);

    int insertSelective(FirstReply record);

    FirstReply selectByPrimaryKey(Integer firstreplyid);

    int updateByPrimaryKeySelective(FirstReply record);

    int updateByPrimaryKey(FirstReply record);
}