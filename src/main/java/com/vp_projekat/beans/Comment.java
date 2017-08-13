package com.vp_projekat.beans;

import java.sql.Timestamp;

/**
 * Created by Lupus on 8/9/2017.
 */
public class Comment {
    private String commentText;
    private Timestamp time;
    private User user;
    private Grade commentGrade;

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
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

    public Grade getCommentGrade() {
        return commentGrade;
    }

    public void setCommentGrade(Grade commentGrade) {
        this.commentGrade = commentGrade;
    }
}
