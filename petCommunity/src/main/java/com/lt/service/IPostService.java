package com.lt.service;

import java.util.List;

import com.lt.pojo.Post;

public interface IPostService {
	
	/**
	 * 查询所有的帖子
	 * 
	 * @return
	 */
	List<Post> selectAllPosts();
	
	/**
	 * 根据主键查询帖子
	 * 
	 * @param uid
	 * @return
	 */
	Post selectPostsById(String pid);
	
	/**
	 * 根据用户查询帖子
	 * 
	 * @param uid
	 * @return
	 */
	List<Post> selectPostsByUser(String uid);
	
	/**
	 * 新增帖子
	 * 
	 * @param post
	 * @return
	 */
	int insertPost(Post post);
	
	/**
	 * 更新帖子
	 * 
	 * @param post
	 * @return
	 */
	int updatePost(Post post);
	
	/**
	 * 根据主键删除帖子
	 * 
	 * @param pid
	 * @return
	 */
	
	int deletePost(String pid);
	
	
	/**
	 * 根据用户删除帖子
	 * 
	 * @param uid
	 * @return
	 */
	int deletePostByUser(String uid);

}
