package com.sakurafly.controller;

import com.sakurafly.pojo.User;
import com.sakurafly.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class addUser extends HttpServlet {
    @Resource
    private IUserService userService;

    /*@RequestMapping("/addUser")
    @ResponseBody
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User(username,password,age);
        this.userService.insert(user);
    }*/
    @RequestMapping("/addUser")
    @ResponseBody
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp){
        resp.setCharacterEncoding("UTF-8");
        //先添加，然后在查询所有已经成功的
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User(username,password,age);
        this.userService.insert(user);

        List<User> lists = userService.selectAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("Users",lists);
        mav.setViewName("selectAll");
        return mav;
    }
}
