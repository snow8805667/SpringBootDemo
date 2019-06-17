package com.fire.domain;

import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id//主键名子
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //JPA为开发人员提供了四种主键生成策略,其被定义在枚举类GenerationType中,包括GenerationType.TABLE,GenerationType.SEQUENCE,GenerationType.IDENTITY和GenerationType.AUTO

    private String name;

    private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswrod() {
		return password;
	}

	public void setPasswrod(String passwrod) {
		this.password = passwrod==null?null:passwrod;
	}
    
}
