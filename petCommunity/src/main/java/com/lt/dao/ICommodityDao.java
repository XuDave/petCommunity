package com.lt.dao;

import java.util.List;

import com.lt.pojo.Commodity;

public interface ICommodityDao {
	List<Commodity> selectAllCommodities();
	
    int deleteByPrimaryKey(Integer commodityid);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer commodityid);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}