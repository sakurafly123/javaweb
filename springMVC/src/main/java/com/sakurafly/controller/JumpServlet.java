package com.sakurafly.controller;

import com.sakurafly.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/jump")
public class JumpServlet {
    @RequestMapping("/addUser")
    @ResponseBody
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addUser");
        return mav;
    }
}
