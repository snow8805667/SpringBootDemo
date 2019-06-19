package com.fire.model;

import javax.validation.constraints.NotNull;

public class VueLoginInfo {
	@NotNull(message="用户名不允许为空")
	private String userName;
	@NotNull(message="密码不允许为空")
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
