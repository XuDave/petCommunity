package com.lt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView findByPost(@RequestParam("id")Integer id,ModelMap model){
		ModelAndView mv = new ModelAndView();
		System.out.println("帖子ID:"+id);
		List<FirstReply>  firstReplyList= firstReplyService.selectFirstReplyByPostId(id);
		System.out.println("一级回复条数："+firstReplyList.size());
		model.addAttribute("firstReplyList", firstReplyList);
		mv.setViewName("firstReply");
		return mv;
	}
}
