package cn.lzq.springboot.mybatis.demo.mapper;

import cn.lzq.springboot.mybatis.demo.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-26 14:58
 */
public interface UserMapper {

    public User findById(int id);
}
