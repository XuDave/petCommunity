package com.lt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.pojo.Commodity;
import com.lt.service.ICommodityService;

@Service
public class CommodityServiceImpl implements ICommodityService {

	@Override
	public List<Commodity> selectAllCommodities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commodity selectCommodityById(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCommodity(Integer cid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
