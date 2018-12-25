package com.sakurafly.controller;

import javax.servlet.http.HttpServletRequest;

import com.sakurafly.pojo.User;
import com.sakurafly.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int userId = parseInt(request.getParameter("id"));
        System.out.println(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        //mapper.writerValuesString(user)转化为json格式的字符串{"id":1,"password":"1","username":"1","age":21,"isdelet":1}
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();

    }
    @RequestMapping(value = "/check.do",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject checkUser(@RequestParam("username") String username)  {
        System.out.println("11111111111111111111");
        JSONObject jsonObject = new JSONObject();
        User user = this.userService.selectUserbyName(username);
        if(user==null){
            //为空，可以使用
            jsonObject.put("result",true);
        }else {
            jsonObject.put("result",false);

        }
        return jsonObject;

    }


}


