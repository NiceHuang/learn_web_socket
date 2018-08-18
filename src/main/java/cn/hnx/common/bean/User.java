package cn.hnx.common.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by viruser on 2018/8/18.
 */
public class User {

    @JSONField(ordinal=1)
    private Integer id;

    @JSONField(ordinal=2)
    private String username;

    @JSONField(ordinal=3)
    private String password;

    @JSONField(format="yyyy-MM-dd", ordinal = 4)
    private Date birthday;

    public User() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
