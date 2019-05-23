package com.djs.test;

public class User {
	public String id;
	public String upw;
	public String uname;
	public User(String id, String upw,String uname) {
		this.id = id;
		this.uname = uname;
		this.upw = upw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
}
