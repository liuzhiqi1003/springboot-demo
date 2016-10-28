package cn.lzq.springboot.jpa.demo.controller;

import cn.lzq.springboot.jpa.demo.dao.UserRepository;
import cn.lzq.springboot.jpa.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-28 10:59
 */

@RestController
public class DataController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public User save(User u){
        u = userRepository.save(u);
        return u;
    }

    @RequestMapping("/q1")
    public List<User> q1(String username){
        return userRepository.findByUsername(username);
    }

    @RequestMapping("/q2")
    public User q2(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @RequestMapping("/q3")
    public User q3(String username,String password){
        return userRepository.withUsernameAndPasswordQuery(username,password);
    }

    @RequestMapping("/q4")
    public User q4(String username,String password){
        return userRepository.withUsernameAndPasswordNameQuery(username,password);
    }

    @RequestMapping("/sort")
    public List<User> sort(){
        return userRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
    }

    @RequestMapping("/page")
    public Page<User> page(){
        return userRepository.findAll(new PageRequest(1,4));
    }
}
