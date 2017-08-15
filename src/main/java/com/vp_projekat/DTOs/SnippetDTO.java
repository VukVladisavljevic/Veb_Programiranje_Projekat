package com.vp_projekat.DTOs;

import com.vp_projekat.beans.Grade;
import com.vp_projekat.beans.User;

/**
 * Created by Lupus on 8/15/2017.
 */

public class SnippetDTO {
    private int id;
    private String description;
    private String code;
    private String programmingLanguage;
    private String repository;
    private int duration;
    private User user;
    private Grade grade;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
    public String getRepository() {
        return repository;
    }
    public void setRepository(String repository) {
        this.repository = repository;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public SnippetDTO(String description, String code, String programmingLanguage,
                      String repository, int duration, User user, Grade grade) {
        super();
        this.description = description;
        this.code = code;
        this.programmingLanguage = programmingLanguage;
        this.repository = repository;
        this.duration = duration;
        this.user = user;
        this.grade = grade;
    }
    public SnippetDTO(String description, String code, String programmingLanguage,
                      String repository, User user, Grade grade) {
        super();
        this.description = description;
        this.code = code;
        this.programmingLanguage = programmingLanguage;
        this.repository = repository;
        this.user = user;
        this.duration = -1;
        this.grade = grade;
    }



    public SnippetDTO(String description, String code, String programmingLanguage,
                      String repository, int duration, User user) {
        super();
        this.description = description;
        this.code = code;
        this.programmingLanguage = programmingLanguage;
        this.repository = repository;
        this.duration = duration;
        this.user = user;
        this.grade = new Grade();
    }

    public SnippetDTO(String description, String code, String programmingLanguage,
                      String repository, User user) {
        super();
        this.description = description;
        this.code = code;
        this.programmingLanguage = programmingLanguage;
        this.repository = repository;
        this.user = user;
        this.duration = -1;
        this.grade = new Grade();
    }
    public SnippetDTO() {}
}
