package cn.lzq.spring.security.demo.dao;

import cn.lzq.spring.security.demo.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-28 17:38
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long>{

    SysUser findByUsername(String username);
}
