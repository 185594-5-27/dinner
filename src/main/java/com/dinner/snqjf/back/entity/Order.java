package com.dinner.snqjf.back.entity;
import java.sql.Timestamp;

/**
 *@author linzf
 **/
public class Order {
	//订单流水ID 
	private int id;
	//订单编号 
	private String orderNum;
	//订单价格 
	private String orderPrice;
	//实际收入 
	private String realIncome;
	//桌号 
	private String tableNum;
	//包间名字 
	private String privateRoom;
	//下单时间 
	private Timestamp orderTime;
	//订单状态（1：待付款；2：已付款；3：订单取消） 
	private String state;
	//下单人 
	private String orderUser;
	//下单人ID 
	private int orderUserId;
	//消费人 
	private String consumeUser;
	//消费人ID 
	private int consumeUserId;
	//消费时间 
	private Timestamp consumeTime;
	//产品积分 
	private int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getRealIncome() {
		return realIncome;
	}

	public void setRealIncome(String realIncome) {
		this.realIncome = realIncome;
	}

	public String getTableNum() {
		return tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	public String getPrivateRoom() {
		return privateRoom;
	}

	public void setPrivateRoom(String privateRoom) {
		this.privateRoom = privateRoom;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

	public int getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}

	public String getConsumeUser() {
		return consumeUser;
	}

	public void setConsumeUser(String consumeUser) {
		this.consumeUser = consumeUser;
	}

	public int getConsumeUserId() {
		return consumeUserId;
	}

	public void setConsumeUserId(int consumeUserId) {
		this.consumeUserId = consumeUserId;
	}

	public Timestamp getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Timestamp consumeTime) {
		this.consumeTime = consumeTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
