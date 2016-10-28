package cn.lzq.springboot.mybatis.demo.controller;

import cn.lzq.springboot.mybatis.demo.model.User;
import cn.lzq.springboot.mybatis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-26 15:14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public User findById(int id){
        return userService.findById(id);
    }
}
