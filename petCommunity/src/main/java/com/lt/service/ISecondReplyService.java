package com.lt.service;

import java.util.List;

import com.lt.pojo.SecondReply;

public interface ISecondReplyService {
   /**
    * 查询全部的二级回复
    * 
    * @return
    */
	List<SecondReply> selectAllSecondReplies();
	
	/**
	 * 根据主键查询二级回复
	 * 
	 * @param sId
	 * @return
	 */
	SecondReply selectSecondReplyById(String sId);
	
	/**
	 * 根据一级回复编号查询相应的二级回复
	 * 
	 * @param pId
	 * @return
	 */
	List<SecondReply> selectSecondReplyByFirstReplyId(String fId);
	
	/**
	 * 根据用户编号查询相应的二级回复
	 * 
	 * @param uId
	 * @return
	 */
	List<SecondReply> selectSecondReplyByUserId(String uId);
	
	/**
	 * 添加二级回复
	 * 
	 * @param secondReply
	 * @return
	 */
	int insertSecondReply(SecondReply secondReply);
	
	/**
	 * 更新二级回复
	 * 
	 * @param secondReply
	 * @return
	 */
	int updateSecondReply(SecondReply secondReply);
	
	/**
	 * 根据主键删除二级回复
	 * 
	 * @param sId
	 * @return
	 */
    int deleteSecondReply(String sId);
    
    /**
     * 根据一级回复删除二级回复
     * 
     * @param fId
     * @return
     */
    int deleteSecondReplyByFirstReply(String fId);
    
    /**
     * 根据用户编号删除二级回复
     * 
     * @param uId
     * @return
     */
    int deleteSecondReplyByUser(String uId);
}
