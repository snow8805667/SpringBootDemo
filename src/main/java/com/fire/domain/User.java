package com.fire.domain;

import javax.persistence.*;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @author fire
 *
 */
@Table(name = "newuser")
public class User {
    @Id//主键名子
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //JPA为开发人员提供了四种主键生成策略,其被定义在枚举类GenerationType中,包括GenerationType.TABLE,GenerationType.SEQUENCE,GenerationType.IDENTITY和GenerationType.AUTO

    private String username;

    private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
