package com.vp_projekat.DTOs;

import com.vp_projekat.beans.Comment;
import com.vp_projekat.beans.Snippet;
import com.vp_projekat.beans.User;

/**
 * Created by Lupus on 8/16/2017.
 */
public class GradeDTO {
    private int grade;
    private User user;
    private Comment comment;
    private Snippet snippet;


    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public GradeDTO(int grade, User user, Comment comment) {
        super();
        this.grade = grade;
        this.user = user;
        this.comment = comment;
    }

    public GradeDTO() {
    }
}