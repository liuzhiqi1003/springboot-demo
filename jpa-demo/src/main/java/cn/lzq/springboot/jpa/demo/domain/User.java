package cn.lzq.springboot.jpa.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-28 10:44
 */
@Entity
@NamedQuery(name = "User.withUsernameAndPasswordNameQuery",query = "select u from User u where u.username = ?1 and u.password = ?2")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public User(){
        super();
    }

    public User(String username, String password, Date createTime) {
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
