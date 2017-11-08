package com.dinner.snqjf.back.entity;

import com.dinner.snqjf.common.base.entity.QueryBase;

/**
 *@author linzf
 **/
public class QueryDiner extends QueryBase {
	//菜名 
	private String name;
	//菜品类型ID 
	private Integer goodTypeId;
	//菜品类型名字 
	private String goodTypeName;
	//价格 
	private String price;
	//销量 
	private Integer sels;
	//图片地址 
	private String imageUrl;
	//创建时间 
	private String createTime;
	//创建人 
	private String createUser;
	//创建人ID 
	private Integer createUserId;
	//优惠价格 
	private String preferentialPrice;
	//是否优惠（1：是；2：否） 
	private String isPreferential;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGoodTypeId() {
		return goodTypeId;
	}

	public void setGoodTypeId(Integer goodTypeId) {
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

	public Integer getSels() {
		return sels;
	}

	public void setSels(Integer sels) {
		this.sels = sels;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
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
