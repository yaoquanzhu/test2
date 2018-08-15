package com.yc.bean;

public class User {
/**
  id        int primary key auto_increment,        
  name      VARCHAR(50),          
  password  VARCHAR(50),          
  telphone VARCHAR(15),        
  username  VARCHAR(50),          
  isadmin   VARCHAR(5)     
 */
	private Integer id;
	private String name;
	private String password;
	private String telphone;
	private String username;
	private String isadmin;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", telphone=" + telphone + ", username=" + username
				+ ", isadmin=" + isadmin + "]";
	}
	
	
}
