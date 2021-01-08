package com.sushko.myapplication;

public class Message {
	private String message;
	private Long userFrom,userTo;
	private Long time;
	
	public Message (Long userFrom,Long userTo,String message, Long time) {
		this.userFrom=userFrom;
		this.userTo=userTo;
		this.message=message;
		this.time=time;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(Long userFrom) {
		this.userFrom = userFrom;
	}
	public Long getUserTo() {
		return userTo;
	}
	public void setUserTo(Long userTo) {
		this.userTo = userTo;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}

}
