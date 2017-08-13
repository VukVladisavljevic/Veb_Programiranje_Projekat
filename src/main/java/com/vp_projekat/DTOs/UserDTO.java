package com.vp_projekat.DTOs;

import com.vp_projekat.beans.Role;

/**
 * Created by Lupus on 8/9/2017.
 */
public class UserDTO {
    //unique
    private String userName;
    private String name;
    private String lastName;
    private String password;
    //role
    private String role;
    private String phone;
    private String email;
    private String address;
    private String picture;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public UserDTO(String userName, String name, String lastName, String password,
                   String role, String phone, String email, String address,
                   String picture) {
        super();
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.picture = picture;
    }

    public UserDTO() {}

    public UserDTO(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }
}