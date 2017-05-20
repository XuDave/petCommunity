package com.lt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lt.pojo.FirstReply;
import com.lt.service.IFirstReplyService;

@Controller
@RequestMapping("/firstReply")
public class FirstReplyController {
   
	@Autowired
	private IFirstReplyService firstReplyService;
	
	private Logger logger = Logger.getLogger(FirstReplyController.class);
	
	@RequestMapping("/findByPost")
	public ModelAndView findByPost(Integer id,ModelMap model){
		ModelAndView mv = new ModelAndView();
		logger.info("删除的id为："+id);
		List<FirstReply>  firstReplyList= firstReplyService.selectFirstReplyByPostId(id);
		model.addAttribute("firstReplyList", firstReplyList);
		mv.setViewName("firstReply");
		return mv;
	}
}
