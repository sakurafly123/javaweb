package com.sakurafly.dao;

import com.sakurafly.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {

    User selectUser(@Param("id")int id);

    User selectUser1(@Param("username") String username, @Param("password")String password);

    List<User> selectAll();

    void update(@Param("username") String username, @Param("password")String password,@Param("id") int id, @Param("age")int age,@Param("isdelet") int isdelet);

    void insert(User user);

    User selectUserbyName(@Param("username")String username);
}