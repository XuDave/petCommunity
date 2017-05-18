package com.lt.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lt.pojo.Admin;
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
		try {
			System.out.println("管理员ID:" + admin.getAdminid());
			Admin ad = adminService.selectAdmin(admin.getAdminid());
			if (ad != null) {
				if (ad.getAdminname().equals(admin.getAdminname())) {
					mv.setViewName("fontPage");
				}
			}
			mv.setViewName("login");

		} catch (Exception e) {
			logger.error("登录异常" + e.toString());
			mv.setViewName("../login");
		}
		return mv;
	}

}
