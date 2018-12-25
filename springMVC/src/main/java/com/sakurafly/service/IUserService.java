package com.sakurafly.service;

import com.sakurafly.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {

    public User selectUser(int id);

    public User selectUserbyName(@Param("username")  String username);

    public User selectUser1(@Param("username") String username, @Param("password") String password);

    public List<User> selectAll();

    public void update(@Param("username") String username,@Param("password") String password, @Param("id")int id, @Param("age")int age,@Param("isdelet") int isdelet);

    public void insert(User user);
}