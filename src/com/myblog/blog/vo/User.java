/**
 * GitHub address:
 * @Title: User.java
 * @Package com.myblog.blog.vo
 * @Description: 封装数据的JavaBean
 * @author: ZSZ
 * @date: 2019/7/23 20:11 PM
 * @version 1.0
 *
 */
package com.myblog.blog.vo;

/**
 * @className User
 * @description 封装用户对象数据
 * @author ZSZ
 * @data 2019/7/23 20:12 PM
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String telephone;
    private String email;
    private int role;
    private String image;
    private int status;

    public User(){}

    public User(int id){
        this.id = id;
    }

    public User(String username){ this.username = username; }

    public User(int id,String password){
        this.id = id;
        this.password = password;
    }

    public User(int id,String username,String password,String sex,String telephone,String email,int role,int status){
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public User(int id,String username,String password,String sex,String telephone,String email,int role,String image,int status){
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.role = role;
        this.image = image;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
