package com.dinner.snqjf.back.entity;
import java.util.Date;

/**
 *@author linzf
 **/
public class DiningTable {
	// 待使用
	public static final String STATE_WAIT_USE = "1";
	// 使用中
	public static final String STATE_USE = "1";
	// 维护中
	public static final String STATE_MAINTENANCE  = "1";

	//桌号流水 
	private int id;
	//桌名 
	private String name;
	//状态（1：待使用；2：使用中；3：维护中）
	private String state;
	//图片地址 
	private String image;
	//创建时间 
	private Date crtDate;
	//创建人 
	private String crtUser;
	//创建人流水ID 
	private int crtUserId;
	//描述 
	private String diningDescribe;
	//备注 
	private String note;
	// 订单ID
	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public int getCrtUserId() {
		return crtUserId;
	}

	public void setCrtUserId(int crtUserId) {
		this.crtUserId = crtUserId;
	}

	public String getDiningDescribe() {
		return diningDescribe;
	}

	public void setDiningDescribe(String diningDescribe) {
		this.diningDescribe = diningDescribe;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
