package com.lt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.IPostDao;
import com.lt.pojo.Post;
import com.lt.service.IPostService;

@Service
public class PostServiceImpl implements IPostService {
	
	@Autowired
	private IPostDao postDao;

	@Override
	public List<Post> selectAllPosts() {
		return postDao.selectAllPosts();
	}

	@Override
	public Post selectPostsById(String pid) {
		return postDao.selectByPrimaryKey(pid);
	}

	@Override
	public List<Post> selectPostsByUser(String uid) {
		return postDao.selectPostsByUser(uid);
	}

	@Override
	public int insertPost(Post post) {
		int i = postDao.insert(post);
		return i;
	}

	@Override
	public int updatePost(Post post) {
		int i = postDao.updateByPrimaryKeySelective(post);
		return i;
	}

	@Override
	public int deletePost(String pid) {
		int i = postDao.deleteByPrimaryKey(pid);
		return i;
	}

	@Override
	public int deletePostByUser(String uid) {
		int i = postDao.deleteByUser(uid);
		return i;
	}


}
