package com.lt.petCommunity.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.petCommunity.dao.UserDaoTest;
import com.lt.pojo.FirstReply;
import com.lt.service.IFirstReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class FirstReplyServiceTest {

	@Autowired
	private IFirstReplyService firstReplyService;
	private Logger logger = Logger.getLogger(UserDaoTest.class);
	
	@Test
	public void testFindByPost(){
		List<FirstReply> list = firstReplyService.selectFirstReplyByPostId(1);
		System.out.println("一级回复条数："+list.size());
	}
	
}
