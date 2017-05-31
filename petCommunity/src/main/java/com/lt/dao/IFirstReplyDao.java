package com.lt.dao;

import java.util.List;

import com.lt.pojo.FirstReply;

public interface IFirstReplyDao {
	
	List<FirstReply> selectAllFirstReplies();
	
	List<FirstReply> selectAllFirstRepliesByPostId(String postid);
	
	List<FirstReply> selectAllFirstRepliesByUserId(String userid);
	
    int deleteByPrimaryKey(String firstreplyid);
    
    int deleteByPostId(String postid);
    
    int deleteByUserId(String userid);

    int insert(FirstReply record);

    int insertSelective(FirstReply record);

    FirstReply selectByPrimaryKey(String firstreplyid);

    int updateByPrimaryKeySelective(FirstReply record);

    int updateByPrimaryKey(FirstReply record);
}