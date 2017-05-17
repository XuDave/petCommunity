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
	public Post selectPostsById(Integer pid) {
		return postDao.selectByPrimaryKey(pid);
	}

	@Override
	public List<Post> selectPostsByUser(Integer uid) {
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
	public int deletePost(Integer pid) {
		int i = postDao.deleteByUser(pid);
		return i;
	}

	@Override
	public int deletePostByUser(Integer uid) {
		int i = postDao.deleteByUser(uid);
		return i;
	}


}
