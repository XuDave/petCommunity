package com.lt.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.alibaba.fastjson.JSON;
import com.lt.pojo.Commodity;
import com.lt.pojo.ProcessResult;
import com.lt.service.ICommodityService;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
	@Autowired
	private ICommodityService commodityService;

	private Logger logger = Logger.getLogger(CommodityController.class);

	@RequestMapping("/commodityList")
	public ModelAndView selectAllCommodities(ModelMap model) {
		ModelAndView mv = new ModelAndView();
		List<Commodity> commodityList = commodityService.selectAllCommodities();
		model.addAttribute("commodityList", commodityList);
		mv.setViewName("commodity");
		return mv;
	}

	@RequestMapping("/deleteCommodity")
	public ModelAndView deleteCommodity(String id, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		try {
			Commodity commodity = commodityService.selectCommodityById(id);
			if (commodity.getCommoditystate() == 0) {
				if (commodity.getCommoditycount() == 0) {
					int i = commodityService.deleteCommodity(id);
					if (i > 0) {
						processResult.setProcessResultDesc("删除商品信息成功！");
					} else {
						processResult.setProcessResultDesc("删除商品信息成功！");
					}
				} else {
					processResult.setProcessResultDesc("商品仍有库存，无法删除此商品！");
				}
			} else {
				processResult.setProcessResultDesc("商品处于上架状态，无法删除此商品！");
			}
		} catch (Exception e) {
			logger.error("删除商品信息异常！" + e.toString());
			processResult.setProcessResultDesc("删除商品信息异常！");
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/commodity/commodityList");
		}
		return mv;
	}

	@RequestMapping("/upCommodity")
	public ModelAndView upCommodity(String id, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		try {
			Commodity commodity = commodityService.selectCommodityById(id);
			commodity.setCommoditystate(1);
			if (commodity.getCommoditycount() > 0) {
				int i = commodityService.updateCommodity(commodity);
				if (i > 0) {
					processResult.setProcessResultDesc("商品上架成功！");
				} else {
					processResult.setProcessResultDesc("商品上架失败！");
				}
			} else {
				processResult.setProcessResultDesc("商品库存为0，无法上架此商品！");
			}
		} catch (Exception e) {
			logger.error("上架商品异常！" + e.toString());
			processResult.setProcessResultDesc("上架商品异常！");
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/commodity/commodityList");
		}
		return mv;
	}

	@RequestMapping("/downCommodity")
	public ModelAndView downCommodity(String id, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		try {
			Commodity commodity = commodityService.selectCommodityById(id);
			commodity.setCommoditystate(0);
			int i = commodityService.updateCommodity(commodity);
			if (i > 0) {
				processResult.setProcessResultDesc("商品下架成功！");
			} else {
				processResult.setProcessResultDesc("商品下架失败！");
			}
		} catch (Exception e) {
			logger.error("下架商品异常！" + e.toString());
			processResult.setProcessResultDesc("下架商品异常！");
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/commodity/commodityList");
		}
		return mv;
	}

	@RequestMapping("/insertCommodity")
	public ModelAndView insertCommodity(Commodity commodity, RedirectAttributesModelMap model) {
		ModelAndView mv = new ModelAndView();
		ProcessResult processResult = new ProcessResult();
		try {
			String uuid = UUID.randomUUID().toString();
			System.out.println("随机生成的uuid:"+uuid);
			commodity.setCommodityid(uuid);
			commodity.setCommodityupdatetime(new Date());
            logger.info(JSON.toJSONString(commodity));
			int i = commodityService.insertCommodity(commodity);
			if (i > 0) {
				processResult.setProcessResultDesc("添加商品信息成功！");
			} else {
				processResult.setProcessResultDesc("添加商品信息成功！");
			}

		} catch (Exception e) {
			logger.error("添加商品信息异常！" + e.toString());
			processResult.setProcessResultDesc("添加商品信息异常！");
		} finally {
			model.addFlashAttribute("processResult", processResult);
			mv.setViewName("redirect:/commodity/commodityList");
		}
		return mv;
	}
}
