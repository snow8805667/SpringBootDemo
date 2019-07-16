package com.fire.dao;

import org.apache.ibatis.annotations.Param;

import com.fire.domain.User;
import com.fire.util.MyMapper;

public interface UserMapper extends MyMapper<User>{

	User findByUsername(@Param("username") String username);
    User findUserById(@Param("Id") String Id);

}
