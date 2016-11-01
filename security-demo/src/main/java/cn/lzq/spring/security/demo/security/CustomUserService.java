package cn.lzq.spring.security.demo.security;

import cn.lzq.spring.security.demo.dao.SysUserRepository;
import cn.lzq.spring.security.demo.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-28 17:43
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userRepository.findByUsername(username);
        if (sysUser == null){
            throw new UsernameNotFoundException("用户名："+username+"不存在");
        }
        return sysUser;
    }
}
