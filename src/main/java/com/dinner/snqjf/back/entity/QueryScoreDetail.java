package com.dinner.snqjf.back.entity;

import com.dinner.snqjf.common.base.entity.QueryBase;

/**
 *@author linzf
 **/
public class QueryScoreDetail extends QueryBase {
	//订单ID 
	private Integer orderId;
	//用户ID 
	private Integer userId;
	//积分类型（1：增加积分；2：扣除积分；3：积分取消） 
	private String type;
	//创建时间 
	private String createTime;
	//消耗积分 
	private Integer score;
	//订单编号 
	private String orderNo;
	//用户姓名 
	private String userName;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
