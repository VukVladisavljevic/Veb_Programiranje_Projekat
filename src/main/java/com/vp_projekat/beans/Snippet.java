package com.vp_projekat.beans;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Lupus on 8/9/2017.
 */
public class Snippet {
    private static int current = 1;
    private int id;
    private String description;
    private String code;
    private String programmingLanguage;
    private String codeRepository;
    private User user;
    private boolean blocked;
    private Timestamp timestamp;
    private ArrayList<Comment> comments;

    public Snippet() {}

    public Snippet(String description, String code, String programmingLanguage,
                   String repository, User user) {
        super();
        this.id = current++;
        this.description = description;
        this.code = code;
        this.programmingLanguage = programmingLanguage;
        this.codeRepository = repository;
        this.user = user;
        this.comments = new ArrayList<Comment>();
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public static int getCurrent() {
        return current;
    }
    public static void setCurrent(int current) {
        Snippet.current = current;
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

    public String getCodeRepository() {
        return codeRepository;
    }

    public void setCodeRepository(String codeRepository) {
        this.codeRepository = codeRepository;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
