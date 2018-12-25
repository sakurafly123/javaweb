package com.sakurafly.controller;

import com.sakurafly.pojo.User;
import com.sakurafly.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class getUserInfo{

    @Resource
    private IUserService userService;
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject CeShi(@RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        User user = this.userService.selectUser(id);
        if(user!=null) {
            jsonObject.put("username", user.getUsername());
            jsonObject.put("age", user.getAge());
            jsonObject.put("id", user.getId());
            jsonObject.put("password", user.getPassword());
        }
        return jsonObject;
    }
}
