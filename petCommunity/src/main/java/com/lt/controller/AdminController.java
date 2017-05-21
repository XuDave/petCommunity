package com.lt.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView checkLogin(Admin admin, ModelMap model,  HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// logger.info("用户为" + JSON.toJSONString(admin));
		ProcessResult processResult = new ProcessResult();
		try {
			Admin ad = adminService.selectByName(admin.getAdminname());
			if (ad != null) {
				if (ad.getPassword().equals(admin.getPassword())) {
					request.getSession().setAttribute("curAdmin", ad);
					//httpSession.setAttribute("curAdmin", ad);
					processResult.setProcessResultDesc("登陆成功！");
					mv.setViewName("fontPage");
				} else {
					processResult.setProcessResultDesc("密码错误！");
					mv.setViewName("../login/login");
				}
			} else {
				processResult.setProcessResultDesc("用户名不存在！");
				mv.setViewName("../login/login");
			}
		} catch (Exception e) {
			processResult.setProcessResultDesc("登录异常！");
			logger.error("登录异常" + e.toString());
			mv.setViewName("../login/login");
		} finally {
			model.addAttribute("processResult", processResult);
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout( HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (request.getSession().getAttribute("curAdmin") != null) {
			request.getSession().removeAttribute("curAdmin");
			request.getSession().invalidate();
		}
		mv.setViewName("redirect:/login/login.jsp");	
		return mv;
	}

	@RequestMapping("/modPsd")
	public ModelAndView modPsd(Admin admin, ModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		try {
			int i = adminService.updateAdmin(admin);
			if (i > 0) {
				processResult.setProcessResultDesc("更改密码成功！");
			} else {
				processResult.setProcessResultDesc("更改密码失败！");
			}
		} catch (Exception e) {
			logger.error("修改密码异常" + e.toString());
		} finally {
			mv.setViewName("admin");
			model.addAttribute("processResult", processResult);
		}
		return mv;
	}

	@RequestMapping(value = "/getAdmin/{aId}", method = RequestMethod.GET)
	public @ResponseBody Admin getAdmin(@PathVariable("aId") Integer aId) {
		Admin admin = adminService.selectAdmin(aId);
		return admin;
	}

}
