package com.dinner.snqjf.back.entity;
import java.sql.Timestamp;

/**
 *@author linzf
 **/
public class OrderDetail {
	//点餐列表流水ID 
	private int id;
	//菜单ID 
	private int dinnerId;
	//订单ID 
	private int orderId;
	//单价 
	private String price;
	//数量 
	private int num;
	//图片地址 
	private String imageUrl;
	//菜品类型名字 
	private String goodTypeName;
	//菜名 
	private String name;
	//优惠价格 
	private String preferentialPrice;
	//是否优惠（1：是；2：否） 
	private String isPreferential;
	//下单时间 
	private Timestamp orderTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDinnerId() {
		return dinnerId;
	}

	public void setDinnerId(int dinnerId) {
		this.dinnerId = dinnerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getGoodTypeName() {
		return goodTypeName;
	}

	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreferentialPrice() {
		return preferentialPrice;
	}

	public void setPreferentialPrice(String preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}

	public String getIsPreferential() {
		return isPreferential;
	}

	public void setIsPreferential(String isPreferential) {
		this.isPreferential = isPreferential;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

}
