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
	public User selectUserById(String uid) {
		return userDao.selectByPrimaryKey(uid);
	}

	@Override
	public int insertUser(User user) {
		int i = userDao.insert(user);
		return i;
	}

	@Override
	public int updateUser(User user) {
		int i = userDao.updateByPrimaryKeySelective(user);
		return i;
	}

	@Override
	public int deleteUser(String uid) {
		int i = userDao.deleteByPrimaryKey(uid);
		return i;
	}

}
