package cn.lzq.springboot.mybatis.demo.service;

import cn.lzq.springboot.mybatis.demo.mapper.UserMapper;
import cn.lzq.springboot.mybatis.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-26 15:13
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(int id){
        return userMapper.findById(id);
    }
}
