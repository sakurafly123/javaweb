package com.sakurafly.service;

import com.sakurafly.dao.IUserDao;
import com.sakurafly.pojo.User;
import com.sakurafly.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public  class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUserbyName(String username) {
        return userDao.selectUserbyName(username);
    }

    public void insert(User user) {
        this.userDao.insert(user);
    }
   /*
    public void update(String username, String password, int id, String age, int isdelet){
        this.userDao.update(username,password,id,age,isdelet);
    }*/

    //查询所有
    public List<User> selectAll() {
        return this.userDao.selectAll();
    }
    //更新数据
    public void update(String username, String password, int id, int age, int isdelet) {
         this.userDao.update(username,password,id,age, isdelet);
    }

    public User selectUser1(String uid, String pwd) {
        return this.userDao.selectUser1(uid,pwd);
    }

    public User selectUser(int userId) {
        return this.userDao.selectUser(userId);
    }

}
