package com.lt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView findByFirstReply(@RequestParam("id")Integer id,ModelMap model){
		ModelAndView mv = new ModelAndView();
		List<SecondReply> secondReplyList = secondReplyService.selectSecondReplyByFirstReplyId(id);
		model.addAttribute("secondReplyList", secondReplyList);
		mv.setViewName("secondReply");
		return mv;
		
	}
	
	@RequestMapping("/deleteSecondReply")
	public ModelAndView deleteSecondReply(Integer id,ModelMap model){
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		int i = secondReplyService.deleteSecondReply(id);
		try{
		if(i>0){
			processResult.setProcessResultDesc("删除二级回复成功！");
		}else{
			processResult.setProcessResultDesc("删除二级回复失败！");
		}
		}catch(Exception e){
			logger.error("删除二级回复异常!"+e.toString());
			processResult.setProcessResultDesc("删除二级回复异常！");
		}finally{
			model.addAttribute("processResult", processResult);
		    mv.setViewName("secondReply");
		}
		return mv;
	}
}
