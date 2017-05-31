package com.lt.dao;

import java.util.List;

import com.lt.pojo.Commodity;

public interface ICommodityDao {
	List<Commodity> selectAllCommodities();
	
    int deleteByPrimaryKey(String commodityid);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(String commodityid);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}