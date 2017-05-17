package com.lt.petCommunity.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.lt.dao.IUserDao;
import com.lt.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class UserDaoTest {

	@Autowired
	private IUserDao userDao;
	
	private Logger logger = Logger.getLogger(UserDaoTest.class);
	
	@Test
	public void testListUsers(){
		List<User> list = userDao.selectAllUsers();
		System.out.println(list.size());
		for(int i = 0;i<list.size();i++){
		logger.info(JSON.toJSONString(list.get(i)));
		}
	}
}
