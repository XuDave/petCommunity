package com.lt.petCommunity.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.petCommunity.dao.UserDaoTest;
import com.lt.pojo.SecondReply;
import com.lt.service.ISecondReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class SecondReplyServiceTest {

	@Autowired
	private ISecondReplyService secondReplyService;
	
	private Logger logger = Logger.getLogger(UserDaoTest.class);
	
	@Test
	public void testFindByFirst(){
		List<SecondReply> list = secondReplyService.selectSecondReplyByFirstReplyId("1");
		System.out.println(list.size());
	}
}
