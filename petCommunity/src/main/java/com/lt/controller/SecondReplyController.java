package com.lt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.alibaba.fastjson.JSON;
import com.lt.pojo.ProcessResult;
import com.lt.pojo.SecondReply;
import com.lt.service.ISecondReplyService;

@Controller
@RequestMapping("/secondReply")
public class SecondReplyController {
	@Autowired
    private ISecondReplyService secondReplyService;
	private Logger logger = Logger.getLogger(SecondReplyController.class);
	
	@RequestMapping("/findByFirstReply")
	public ModelAndView findByFirstReply(@RequestParam("id")String id,ModelMap model){
		ModelAndView mv = new ModelAndView();
		List<SecondReply> secondReplyList = secondReplyService.selectSecondReplyByFirstReplyId(id);
		model.addAttribute("secondReplyList", secondReplyList);
		mv.setViewName("secondReply");
		return mv;
		
	}
	
	@RequestMapping("/deleteSecondReply")
	public ModelAndView deleteSecondReply(String id,RedirectAttributesModelMap model){
		ModelAndView mv = new ModelAndView();
		logger.info("二级回复id："+id);
		ProcessResult processResult = new ProcessResult();
	    SecondReply sr = secondReplyService.selectSecondReplyById(id);
	    System.out.println(JSON.toJSONString(sr)+sr.getFirstreplyid());
		try{
			int i = secondReplyService.deleteSecondReply(id);
		if(i>0){
			processResult.setProcessResultDesc("删除二级回复成功！");
		}else{
			processResult.setProcessResultDesc("删除二级回复失败！");
		}
		}catch(Exception e){
			logger.error("删除二级回复异常!"+e.toString());
			processResult.setProcessResultDesc("删除二级回复异常！");
		}finally{
			model.addFlashAttribute("processResult", processResult);
		    mv.setViewName("redirect:/secondReply/findByFirstReply?id="+sr.getFirstreplyid());
		}
		return mv;
	}
}
