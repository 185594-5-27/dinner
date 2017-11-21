package com.dinner.snqjf.back.entity;
import java.util.Date;

/**
 *@author linzf
 **/
public class ScoreDetail {

	// 增加积分
	public static final String ADD_TYPE = "1";
	// 减少积分
	public static final String REDUCE_TYPE = "2";
	// 取消积分
	public static final String CANCEL_TYPE = "3";

	//积分流水ID 
	private int id;
	//订单ID 
	private int orderId;
	//用户ID 
	private int userId;
	//积分类型（1：增加积分；2：扣除积分；3：积分取消） 
	private String type;
	//创建时间 
	private Date createTime;
	//消耗积分 
	private int score;
	//订单编号 
	private String orderNo;
	//用户姓名 
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
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
