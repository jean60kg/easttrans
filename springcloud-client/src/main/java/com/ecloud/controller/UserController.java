package com.ecloud.controller;

import com.ecloud.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2020/5/20.
 */
@Controller
@RequestMapping("/user")
@MapperScan("com.ecloud.dao")
public class UserController {
    @Autowired(required=false)
    private UserService userService;//注入Service

    @ResponseBody
    @RequestMapping(value = "/queryCount", method = RequestMethod.GET)
    public int queryCount() {
        int count = userService.queryCount();
        return count;
    }

}
