package com.lt.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lt.pojo.Admin;
import com.lt.pojo.ProcessResult;
import com.lt.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	Logger logger = Logger.getLogger(AdminController.class);

	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(Admin admin, ModelMap model) {
		ModelAndView mv = new ModelAndView();
		logger.info("用户为" + JSON.toJSONString(admin));
		ProcessResult processResult = new ProcessResult();
		try {
			System.out.println("管理员用户名:" + admin.getAdminname());
			Admin ad = adminService.selectByName(admin.getAdminname());
			if (ad != null) {
				if (ad.getPassword().equals(admin.getPassword())) {
					mv.setViewName("fontPage");
				}else{
					processResult.setProcessResultDesc("密码错误！");
					mv.setViewName("../login/login");
				}
			} else{
				processResult.setProcessResultDesc("用户名不存在！");
				mv.setViewName("../login/login");
			}
		} catch (Exception e) {
			processResult.setProcessResultDesc("登录异常！");
			logger.error("登录异常" + e.toString());
			mv.setViewName("../login/login");
		}finally {
			model.addAttribute("processResult", processResult);
		}
		return mv;
	}

}
