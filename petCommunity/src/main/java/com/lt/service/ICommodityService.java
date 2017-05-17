package com.lt.service;

import java.util.List;

import com.lt.pojo.Commodity;

public interface ICommodityService {
	
	/**
	 * 查询全部的商品
	 * 
	 * @return
	 */
	List<Commodity> selectAllCommodities();
	
	/**
	 * 根据主键查询商品
	 * 
	 * @param cid
	 * @return
	 */
	Commodity selectCommodityById(Integer cid);
	
	/**
	 * 添加商品
	 * 
	 * @param commodity
	 * @return
	 */
	int insertCommodity(Commodity commodity);
	
	/**
	 * 更新商品
	 * 
	 * @param commodity
	 * @return
	 */
	int updateCommodity(Commodity commodity);
	
	/**
	 * 删除商品
	 * 
	 * @param cid
	 * @return
	 */
	int deleteCommodity(Integer cid);
	
}
