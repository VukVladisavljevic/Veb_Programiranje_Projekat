package com.vp_projekat.beans;

import java.sql.Timestamp;

/**
 * Created by Lupus on 8/9/2017.
 */
public class Comment {
    private static int current = 1;
    private int id;
    private String text;
    private Timestamp time;
    private User user;
    private Grade grade;


    public static int getCurrent() {
        return current;
    }
    public static void setCurrent(int current) {
        Comment.current = current;
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
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public Comment(String text, User user, Grade grade) {
        super();
        this.id = current++;
        this.text = text;
        this.time = new Timestamp(System.currentTimeMillis());
        this.user = user;
        this.grade = grade;
    }

    public Comment(String text, User user) {
        super();
        this.id = current++;
        this.text = text;
        this.time = new Timestamp(System.currentTimeMillis());
        this.user = user;
        this.grade = new Grade();
    }

    public Comment(int id, String text, Timestamp time, User user, Grade grade) {
        super();
        this.id = id;
        this.text = text;
        this.time = time;
        this.user = user;
        this.grade = grade;
    }
    public Comment() {
        super();
        this.id = current++;
        this.grade = new Grade();
    }

    public void gradeComment(User user, int grade)
    {
        if(grade == 1){
            this.grade.positive(user);
        }
        else if(grade == -1){
            this.grade.negative(user);
        }
    }

}
