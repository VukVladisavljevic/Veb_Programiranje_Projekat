package com.vp_projekat.DTOs;

import com.vp_projekat.beans.Snippet;
import com.vp_projekat.beans.User;

import java.sql.Timestamp;

/**
 * Created by Lupus on 8/16/2017.
 */
public class CommentDTO {
    private int id;
    private String text;
    private Timestamp time;
    private User user;
    private Snippet snippet;
    public Snippet getSnippet() {
        return snippet;
    }
    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Timestamp getTime() {
        return time;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public CommentDTO(String text, User user) {
        this.text = text;
        this.time = new Timestamp(System.currentTimeMillis());
        this.user = user;
    }

    public CommentDTO(int id, String text, Timestamp time, User user) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.user = user;
    }
    public CommentDTO() {
    }
}