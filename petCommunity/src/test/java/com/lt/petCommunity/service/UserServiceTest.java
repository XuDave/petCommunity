package com.lt.petCommunity.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class UserServiceTest {

	@Autowired
	private IUserService userService;

	@Test
	public void deleteUser() {
		int i = userService.deleteUser("8");
		System.out.println("成功删除" + i + "条用户信息");
	}

}
