package com.lt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lt.pojo.Post;
import com.lt.service.IPostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private IPostService postService;
	
	private Logger logger = Logger.getLogger(PostController.class);
	
	@RequestMapping("/postList")
	public ModelAndView selectAllPosts(ModelMap model){
		ModelAndView mv = new ModelAndView();
		List<Post> postList = postService.selectAllPosts();
		model.addAttribute("postList", postList);
		mv.setViewName("post");
		return mv;
	}

}
