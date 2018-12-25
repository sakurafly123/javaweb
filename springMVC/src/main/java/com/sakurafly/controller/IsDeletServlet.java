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

import static java.lang.Integer.parseInt;

@Controller
public class IsDeletServlet /*extends HttpServlet */{
    @Resource
    private IUserService userService;

    @RequestMapping("/disabled")
    @ResponseBody
   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int name =  parseInt(req.getParameter("id"));
        if(name==0){
            System.out.println("name为空");
        }else {
            System.out.println("非空");
        }
        int i = (int)name;
        User user = this.userService.selectUser(i);
        this.userService.update(user.getUsername(),user.getPassword(),user.getId(),user.getAge(),1);
        resp.sendRedirect("/selectAll");
    }*/
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();
        int name = parseInt(req.getParameter("id"));
        if (name == 0) {
            System.out.println("name为空");
        } else {
            System.out.println("非空");
        }
        int i = (int) name;
        User user = this.userService.selectUser(i);
        this.userService.update(user.getUsername(), user.getPassword(), user.getId(), user.getAge(), 1);
        List<User> lists = userService.selectAll();
        mav.addObject("Users", lists);
        mav.setViewName("selectAll");
        return mav;
    }
}