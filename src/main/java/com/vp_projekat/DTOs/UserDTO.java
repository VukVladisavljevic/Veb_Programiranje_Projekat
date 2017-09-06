package com.vp_projekat.DTOs;

/**
 * Created by Lupus on 8/9/2017.
 */
public class UserDTO {
    //unique
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    //role
    private String role;
    private String phone;
    private String email;
    private String address;
    private String picture;

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
    public UserDTO(String username, String firstName, String lastName, String password,
                   String role, String phone, String email, String address,
                   String picture) {
        super();
        this.setUsername(username);
        this.setFirstName(firstName);
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.picture = picture;
    }

    public UserDTO() {}

    public UserDTO(String username, String password)
    {
        this.setUsername(username);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}