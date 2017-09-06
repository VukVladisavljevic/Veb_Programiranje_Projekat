package com.vp_projekat.services;

import com.vp_projekat.DTOs.UserDTO;
import com.vp_projekat.beans.User;
import com.vp_projekat.beans.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/9/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User register(UserDTO userDTO){
        Users.load();
        User retUser = Users.getUser(userDTO.getUsername());
        if(retUser != null)
        {
            return null;
        }

        User newUser = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstName(),
                userDTO.getLastName(), userDTO.getRole(), userDTO.getPhone(), userDTO.getEmail(),
                userDTO.getAddress(), userDTO.getPicture());

        Users.addUser(newUser);
        return  newUser ;
    }

    @Override
    public User login(UserDTO userDTO) {
        Users.load();
        User retUser = Users.getUser(userDTO.getUsername());
        if(retUser != null) {
            if(retUser.getPassword().equals(userDTO.getPassword())) {
                return retUser;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        Users.load();
        return Users.getUsers();
    }

    @Override
    public User block(UserDTO userDTO) {
        Users.load();
        User userFound = Users.getUser(userDTO.getUsername());

        if(userFound == null){
            return null;
        }

        userFound.setBlocked(true);
        Users.save();
        return userFound;
    }

    @Override
    public User unblock(UserDTO userDTO) {
        Users.load();
        User userFound = Users.getUser(userDTO.getUsername());

        if(userFound == null){
            return null;
        }

        userFound.setBlocked(false);
        Users.save();
        return userFound;
    }

}
