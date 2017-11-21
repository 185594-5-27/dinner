package com.dinner.snqjf.back.entity;
import java.util.Date;

/**
 *@author linzf
 **/
public class MobileUser {

	public MobileUser(){
		super();
	}

	public MobileUser(String phone){
		this.phone = phone;
	}

	//点餐用户流水ID 
	private int id;
	//名字 
	private String name;
	//电话 
	private String phone;
	//密码 
	private String pass;
	//积分 
	private int score;
	//创建时间 
	private Date createTime;
	//性别（男 或者 女） 
	private String sex;
	//年龄 
	private int age;
	//最近消费时间 
	private Date consumeTime;
	//最近消费金额 
	private String consumeMoney;
	//登陆的token 
	private String token;
	//最后登陆时间 
	private Date lastLoginTime;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Date consumeTime) {
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

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
