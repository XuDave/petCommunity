package com.lt.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lt.pojo.Commodity;
import com.lt.service.ICommodityService;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
   @Autowired
   private ICommodityService commodityService;
   
   private Logger logger = Logger.getLogger(CommodityController.class);
   
   @RequestMapping("/commodityList")
   public ModelAndView selectAllCommodities(ModelMap model){
	   ModelAndView mv = new ModelAndView();
	   List<Commodity> commodityList = commodityService.selectAllCommodities();
	   model.addAttribute("commodityList", commodityList);
	   mv.setViewName("commodity");
	   return mv;
   }
}
