package com.sakurafly.controller;

import com.sakurafly.pojo.User;
import com.sakurafly.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LoginServlet  extends HttpServlet {

    @Resource
    private IUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*使用表单提交的，会转化成参数，此时接受需要用Parameter
        * req返回浏览器，可以使用setAttrubutes(keyname,value)形式
        * 取得时候就使用req.getAttrubutes(keyname);
        * */
        String uid = req.getParameter("username");
        String pwd = req.getParameter("password");
        User user = this.userService.selectUser1(uid,pwd);
        resp.setCharacterEncoding("gbk");
        PrintWriter writer;
        System.out.println("11111");
        if (user!=null){
            //请求转发
            req.getRequestDispatcher("/success.jsp").forward(req,resp);

        }else {
            //请求转发

            req.getRequestDispatcher("/failed.jsp").forward(req,resp);


        }

    }
}
