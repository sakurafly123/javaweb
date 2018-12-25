package com.sakurafly.controller;

import com.sakurafly.pojo.User;
import com.sakurafly.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SelectAllSerlevt {
    @Resource
    private IUserService userService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp){
        resp.setCharacterEncoding("UTF-8");
        List<User> lists = userService.selectAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("Users",lists);
        mav.setViewName("selectAll");
        return mav;
    }
}
