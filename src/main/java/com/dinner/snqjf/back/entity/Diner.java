package com.dinner.snqjf.back.entity;
import java.sql.Timestamp;
import java.util.Date;

/**
 *@author linzf
 **/
public class Diner {
	//菜单流水ID 
	private int id;
	//菜名 
	private String name;
	//菜品类型ID 
	private int goodTypeId;
	//菜品类型名字 
	private String goodTypeName;
	//价格 
	private String price;
	//销量 
	private int sels;
	//图片地址 
	private String imageUrl;
	//创建时间 
	private Date createTime;
	//创建人 
	private String createUser;
	//创建人ID 
	private int createUserId;
	//优惠价格 
	private String preferentialPrice;
	//是否优惠（1：是；2：否） 
	private String isPreferential;

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

	public int getGoodTypeId() {
		return goodTypeId;
	}

	public void setGoodTypeId(int goodTypeId) {
		this.goodTypeId = goodTypeId;
	}

	public String getGoodTypeName() {
		return goodTypeName;
	}

	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getSels() {
		return sels;
	}

	public void setSels(int sels) {
		this.sels = sels;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
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

}
