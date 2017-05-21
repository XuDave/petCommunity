package com.lt.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.lt.pojo.Pet;
import com.lt.pojo.ProcessResult;
import com.lt.service.IPetService;
import com.lt.service.IPetTypeService;

@Controller
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private IPetService petService;
	@Autowired
	private IPetTypeService petTypeService;

	private Logger logger = Logger.getLogger(PetController.class);

	@RequestMapping("/findPetByUser")
	public ModelAndView findPetByPost(@RequestParam("id") Integer id, ModelMap model) {
		ModelAndView mv = new ModelAndView();
		List<Pet> petList = new ArrayList<Pet>();
		List<Pet> pets = petService.selectPetByUserId(id);
		for(Pet pet : pets){
			pet.setPettypename(petTypeService.selectPetType(pet.getPettypeid()).getPettypename());
			petList.add(pet);
		}
		model.addAttribute("petList", petList);
		mv.setViewName("pet");
		return mv;
	}

	@RequestMapping("/deletePet")
	public ModelAndView deletePet(Integer id, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		Pet pet = petService.selectPetById(id);
		try {
			int i = petService.deletePet(id);
			if (i > 0) {
				processResult.setProcessResultDesc("删除宠物信息成功！");
			} else {
				processResult.setProcessResultDesc("删除宠物信息失败！");
			}
		} catch (Exception e) {
			logger.error("删除宠物信息异常！" + e.toString());
			processResult.setProcessResultDesc("删除宠物信息异常！");
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/pet/findPetByUser?id=" + pet.getUserid());
		}
		return mv;
	}
}
