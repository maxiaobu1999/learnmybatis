package com.norman.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class User implements Serializable{



    private Integer userId;
    private String userName;
    private Date birthday;
    private String sex;
    private String address;


    public String getUserName() {
        return userName;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setUserName(String username) {
        this.userName = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
