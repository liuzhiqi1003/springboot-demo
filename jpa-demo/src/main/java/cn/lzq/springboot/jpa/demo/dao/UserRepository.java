package cn.lzq.springboot.jpa.demo.dao;

import cn.lzq.springboot.jpa.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-28 10:52
 */
public interface UserRepository extends JpaRepository<User,Integer>{

    List<User> findByUsername(String username);

    User findByUsernameAndPassword(String username,String password);

    @Query("select u from User u where u.username = :username and u.password = :password")
    User withUsernameAndPasswordQuery(@Param("username") String username, @Param("password") String password);

    User withUsernameAndPasswordNameQuery(String username,String password);
}
