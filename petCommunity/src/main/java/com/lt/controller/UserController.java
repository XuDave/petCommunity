
package com.lt.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.lt.pojo.ProcessResult;
import com.lt.pojo.User;
import com.lt.service.IFirstReplyService;
import com.lt.service.IPetService;
import com.lt.service.IPostService;
import com.lt.service.ISecondReplyService;
import com.lt.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IPetService petService;
	@Autowired
	private IFirstReplyService firstReplyService;
	@Autowired
	private ISecondReplyService secondReplyService;
	@Autowired
	private IPostService postService;

	private Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping("/userList")
	public ModelAndView listAllUser(ModelMap model) {
		ModelAndView mv = new ModelAndView();
		List<User> userList = userService.selectAllUsers();
		model.addAttribute("userList", userList);
		mv.setViewName("user");
		return mv;
	}

	@RequestMapping("/resetPsd")
	public ModelAndView resetPsd(Integer id, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		try {
			//User user = userService.selectUserById(id);
			//System.out.println(JSON.toJSONString(user));
			User user = new User();
			user.setUserid(id);
			user.setUserpassword("123");
			int i = userService.updateUser(user);
			if (i > 0) {
				processResult.setProcessResultDesc("重置密码成功！新密码为123！");
			} else {
				processResult.setProcessResultDesc("重置密码失败！");
			}
		} catch (Exception e) {
			logger.error("重置密码异常！" + e.toString());
			processResult.setProcessResultDesc("重置密码异常！");
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/user/userList");
		}
		return mv;
	}
	
	@RequestMapping("/deleteUser")
	@Transactional
	public ModelAndView deleteUser(Integer id, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		System.out.println(id);
		try {
			secondReplyService.deleteSecondReplyByUser(id);
			firstReplyService.deleteFirstReplyByUserId(id);
			postService.deletePostByUser(id);
			petService.deletePetByUserId(id);
			int i = userService.deleteUser(id);
			if (i > 0) {
				processResult.setProcessResultDesc("删除用户成功");
			} else {
				processResult.setProcessResultDesc("删除用户失败！");
			}
		} catch (Exception e) {
			logger.error("删除用户异常！" + e.toString());
			processResult.setProcessResultDesc("删除用户异常！");
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/user/userList");
		}
		return mv;
	}


}
