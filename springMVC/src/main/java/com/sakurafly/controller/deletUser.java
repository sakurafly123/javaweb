package com.sakurafly.controller;

import com.sakurafly.pojo.User;
import com.sakurafly.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class deletUser {
    @Resource
    private IUserService userService;
    @RequestMapping(value = "/deletUser", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject CeShi(@RequestParam(value = "idlist[]") String[] str) {
        System.out.println("11111");
        JSONObject jsonObject = new JSONObject();
        List<Integer> lists = new ArrayList<Integer>();
        for (String s:str) {
            System.out.println(s);
            lists.add(Integer.parseInt(s));
        }
        for (Integer i:lists) {
            User user = this.userService.selectUser(i);
            this.userService.update(user.getUsername(), user.getPassword(), user.getId(), user.getAge(), 1);
        }
        jsonObject.put("result",200);
        return jsonObject;
    }
    /*当使用http请求时传入数据*/
    /*public JSONObject CeShi1( HttpServletRequest request, HttpServletResponse response) {
        System.out.println("11111");
        JSONObject jsonObject = new JSONObject();
        String str =request.getParameter("idlist");
        String[] s = str.split(",");
        for (String s1:s) {
            System.out.println(s1);
        }
        jsonObject.put("result",200);
        return jsonObject;
    }*/
    /*public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
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
    }*/
}
