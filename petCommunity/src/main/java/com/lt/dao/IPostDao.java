package com.lt.dao;

import java.util.List;

import com.lt.pojo.Post;

public interface IPostDao {
	
	List<Post> selectAllPosts();
	
	List<Post> selectPostsByUser(String userId);
	
    int deleteByPrimaryKey(String postid);
    
    int deleteByUser(String userId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(String postid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}