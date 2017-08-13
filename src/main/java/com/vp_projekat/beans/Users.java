package com.vp_projekat.beans;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lupus on 8/9/2017.
 */
public class Users {

    private static ArrayList<User> users = new ArrayList<User>();

    public static void addUser(User user)
    {
        Users.users.add(user);
        save();
    }

    public Users(ArrayList<User> users) {
        super();
        Users.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public Users()
    {
        load();
    }

    public static User getUser(String userName)
    {
        User user = null;
        for (User u : Users.users) {
            if(u.getUsername().equals(userName))
            {
                user = u;
            }
        }
        return user;
    }

    public static void load(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./src/users.json"));
            String json = "";
            String line;
            while((line = reader.readLine()) != null)
            {
                json += line;
            }
            Users.users = mapper.readValue(json,
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
            reader.close();

            System.out.println(json);
            System.out.println(Users.users.size());
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void save() {
        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in file
        try {
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("./src/users.json"), Users.users);
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
