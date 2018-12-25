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
public class UpdateServlet /*extends HttpServlet*/ {
    @Resource
    private IUserService userService;

    @RequestMapping("/updateUser")
    @ResponseBody
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();
        //获取id,password,username,age.
        String password = (String) req.getParameter("password");
        int id =Integer.parseInt(req.getParameter("Id"));
        String username = (String) req.getParameter("username");
        int age =Integer.parseInt(req.getParameter("age"));

        this.userService.update(username,password,id,age,0);
        List<User> lists = userService.selectAll();
        mav.addObject("Users", lists);
        mav.setViewName("selectAll");
        return mav;
    }

   /* @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = (String) req.getParameter("password");
        int id =Integer.parseInt(req.getParameter("Id"));
        String username = (String) req.getParameter("username");
        int age =Integer.parseInt(req.getParameter("age"));
        this.userService.update(username,password,id,age,0);
        req.getRequestDispatcher("/selecAll").forward(req,resp);


    }*/
}
