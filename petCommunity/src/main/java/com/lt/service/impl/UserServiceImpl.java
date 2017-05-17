package com.lt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.IUserDao;
import com.lt.pojo.User;
import com.lt.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<User> selectAllUsers() {
		return userDao.selectAllUsers();
	}

	@Override
	public User selectUserById(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer uid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
