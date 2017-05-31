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
import com.lt.pojo.ProcessResult;
import com.lt.pojo.SecondReply;
import com.lt.service.IFirstReplyService;
import com.lt.service.ISecondReplyService;

@Controller
@RequestMapping("/firstReply")
public class FirstReplyController {

	@Autowired
	private IFirstReplyService firstReplyService;

	@Autowired
	private ISecondReplyService secondReplyService;

	private Logger logger = Logger.getLogger(FirstReplyController.class);

	@RequestMapping("/findByPost")
	public ModelAndView findByPost(@RequestParam("id") String id, ModelMap model) {
		ModelAndView mv = new ModelAndView();
		List<FirstReply> firstReplyList = firstReplyService.selectFirstReplyByPostId(id);
		System.out.println("一级回复条数：" + firstReplyList.size());
		model.addAttribute("firstReplyList", firstReplyList);
		mv.setViewName("firstReply");
		return mv;
	}

	@RequestMapping("/deleteFirstReply")
	@Transactional
	public ModelAndView deletePost(String id, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		System.out.println("删除的id:" + id);
		FirstReply fr = firstReplyService.selectFirstReply(id);
		try {
			
			secondReplyService.deleteSecondReplyByFirstReply(id);
			int i = firstReplyService.deleteFirstReply(id);
			if (i > 0) {
				processResult.setProcessResultDesc("删除一级回复成功！");
			} else {
				processResult.setProcessResultDesc("删除一级回复失败！");
			}

		} catch (Exception e) {
			processResult.setProcessResultDesc("删除一级回复异常！");
			logger.error("删除一级回复异常!" + e.toString());
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/firstReply/findByPost?id="+fr.getPostid());
		}
		return mv;
	}
}
