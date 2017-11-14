package com.dinner.snqjf.back.entity;

import com.dinner.snqjf.common.base.entity.QueryBase;

/**
 *@author linzf
 **/
public class QueryDiningTable extends QueryBase {
	//桌名 
	private String name;
	//状态（1：待使用；2：使用中；3：维护中） 
	private String state;
	//图片地址 
	private String image;
	//创建时间 
	private String crtDate;
	//创建人 
	private String crtUser;
	//创建人流水ID 
	private Integer crtUserId;
	//描述 
	private String diningDescribe;
	//备注 
	private String note;

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

	public String getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public Integer getCrtUserId() {
		return crtUserId;
	}

	public void setCrtUserId(Integer crtUserId) {
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
