
package com.lt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lt.pojo.User;
import com.lt.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping("/userList")
	public ModelAndView listAllUser(ModelMap model){
		ModelAndView mv = new ModelAndView();
		List<User> userList = userService.selectAllUsers();
		model.addAttribute("userList", userList);
		mv.setViewName("user");
		return mv;
	}

}
