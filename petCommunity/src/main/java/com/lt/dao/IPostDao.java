package com.lt.dao;

import java.util.List;

import com.lt.pojo.Post;

public interface IPostDao {
	
	List<Post> selectAllPosts();
	
	List<Post> selectPostsByUser(Integer userId);
	
    int deleteByPrimaryKey(Integer postid);
    
    int deleteByUser(Integer userId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer postid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}