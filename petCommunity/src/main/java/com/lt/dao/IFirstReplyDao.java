package com.lt.dao;

import java.util.List;

import com.lt.pojo.FirstReply;

public interface IFirstReplyDao {
	
	List<FirstReply> selectAllFirstReplies();
	
	List<FirstReply> selectAllFirstRepliesByPostId(Integer postid);
	
	List<FirstReply> selectAllFirstRepliesByUserId(Integer userid);
	
    int deleteByPrimaryKey(Integer firstreplyid);
    
    int deleteByPostId(Integer postid);
    
    int deleteByUserId(Integer userid);

    int insert(FirstReply record);

    int insertSelective(FirstReply record);

    FirstReply selectByPrimaryKey(Integer firstreplyid);

    int updateByPrimaryKeySelective(FirstReply record);

    int updateByPrimaryKey(FirstReply record);
}