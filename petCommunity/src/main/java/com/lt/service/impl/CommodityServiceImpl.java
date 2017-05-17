package com.lt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.ICommodityDao;
import com.lt.pojo.Commodity;
import com.lt.service.ICommodityService;

@Service
public class CommodityServiceImpl implements ICommodityService {

	@Autowired
	private ICommodityDao commodityDao;
	
	@Override
	public List<Commodity> selectAllCommodities() {
		return commodityDao.selectAllCommodities();
	}

	@Override
	public Commodity selectCommodityById(Integer cid) {
		return commodityDao.selectByPrimaryKey(cid);
	}

	@Override
	public int insertCommodity(Commodity commodity) {
		int i = commodityDao.insert(commodity);
		return i;
	}

	@Override
	public int updateCommodity(Commodity commodity) {
		int i = commodityDao.updateByPrimaryKeySelective(commodity);
		return i;
	}

	@Override
	public int deleteCommodity(Integer cid) {
		int i = commodityDao.deleteByPrimaryKey(cid);
		return i;
	}

}
