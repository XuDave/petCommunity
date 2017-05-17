package com.lt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.pojo.Post;
import com.lt.service.IPostService;

@Service
public class PostServiceImpl implements IPostService {

	@Override
	public List<Post> selectAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post selectPostsById(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> selectPostsByUser(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertPost(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePost(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePost(Integer pid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePostByUser(Integer uid) {
		// TODO Auto-generated method stub
		return 0;
	}


}
