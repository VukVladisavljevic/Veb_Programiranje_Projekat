package com.vp_projekat.beans;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/9/2017.
 */
public class Grade {
    private ArrayList<User> users;
    private int positive;
    private int negative;
    public int getPositive() {
        return positive;
    }


    public ArrayList<User> getUsers() {
        return users;
    }


    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }


    public void setPositive(int positive) {
        this.positive = positive;
    }
    public int getNegative() {
        return negative;
    }
    public void setNegative(int negative) {
        this.negative = negative;
    }
    public Grade(int positive, int negative, ArrayList<User> users) {
        super();
        this.users = users;
        this.positive = positive;
        this.negative = negative;
    }

    public Grade()
    {
        this.users = new ArrayList<User>();
        this.positive = 0;
        this.negative = 0;
    }

    public void positive(User user)
    {
        if(this.graded(user.getUsername())) return;
        this.positive++;
        this.users.add(user);
    }

    public void negative(User user)
    {
        if(this.graded(user.getUsername())) return;
        this.negative++;
        this.users.add(user);
    }

    public boolean graded(String userName)
    {
        for(User u:this.users)
        {
            if(u.getUsername().equals(userName))
            {
                return true;
            }
        }
        return false;
    }
}

