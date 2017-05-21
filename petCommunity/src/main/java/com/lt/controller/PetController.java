package com.lt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lt.pojo.Pet;
import com.lt.service.IPetService;

@Controller
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private IPetService petService;
	
	private Logger logger = Logger.getLogger(PetController.class);
	
	@RequestMapping("/findPetByUser")
	public ModelAndView findPetByPost(@RequestParam("id")Integer id,ModelMap model){
		ModelAndView mv = new ModelAndView();
		List<Pet> petList = petService.selectPetByUserId(id);
		model.addAttribute("petList", petList);
		mv.setViewName("pet");
		return mv;
	}
}
