package com.lt.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.lt.pojo.FirstReply;
import com.lt.pojo.Post;
import com.lt.pojo.ProcessResult;
import com.lt.service.IFirstReplyService;
import com.lt.service.IPostService;
import com.lt.service.ISecondReplyService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private IPostService postService;

	@Autowired
	private IFirstReplyService firstReplyService;

	@Autowired
	private ISecondReplyService secondReplyService;

	private Logger logger = Logger.getLogger(PostController.class);

	@RequestMapping("/postList")
	public ModelAndView selectAllPosts(ModelMap model) {
		ModelAndView mv = new ModelAndView();
		List<Post> postList = postService.selectAllPosts();
		model.addAttribute("postList", postList);
		mv.setViewName("post");
		return mv;
	}

	@RequestMapping("/deletePost")
	@Transactional
	public ModelAndView deletePost(String id, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		System.out.println("删除的id:" + id);
		try {
			List<FirstReply> flist = firstReplyService.selectFirstReplyByPostId(id);
			for (FirstReply fr : flist) {
				secondReplyService.deleteSecondReply(fr.getFirstreplyid());
			}
			firstReplyService.deleteFirstReplyByPostId(id);
			int i = postService.deletePost(id);
			if (i > 0) {
				processResult.setProcessResultDesc("删除帖子成功！");
			} else {
				processResult.setProcessResultDesc("删除帖子失败！");
			}

		} catch (Exception e) {
			processResult.setProcessResultDesc("删除帖子异常！");
			logger.error("删除帖子异常!" + e.toString());
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/post/postList");
		}
		return mv;
	}

}
