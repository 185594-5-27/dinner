package com.dinner.snqjf.back.entity;

import com.dinner.snqjf.common.base.entity.QueryBase;

/**
 *@author linzf
 **/
public class QueryMobileUser extends QueryBase {
	//名字 
	private String name;
	//电话 
	private String phone;
	//密码 
	private String pass;
	//积分 
	private Integer score;
	//创建时间 
	private String createTime;
	//性别（男 或者 女） 
	private String sex;
	//年龄 
	private Integer age;
	//最近消费时间 
	private String consumeTime;
	//最近消费金额 
	private String consumeMoney;
	//登陆的token 
	private String token;
	//最后登陆时间 
	private String lastLoginTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(String consumeTime) {
		this.consumeTime = consumeTime;
	}

	public String getConsumeMoney() {
		return consumeMoney;
	}

	public void setConsumeMoney(String consumeMoney) {
		this.consumeMoney = consumeMoney;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
