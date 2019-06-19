package com.fire.tools;

public enum ResultCode {
	/**
	 * 成功
	 */
	success(200),
	/**
	 * 失败
	 */
	FAIL(400),
	
	/**
	 * 未知
	 */
	UNAUTHORIZED(401),
	
	/**
	 * 未找到服务器
	 */
	NOT_FOUND(404),
	
	/**
	 * 服务器内部错误
	 */
	INTERNAL_SERVER_ERROR(500);
	
	public int code;
	
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	ResultCode(int code){
		this.code=code;
	}
}
