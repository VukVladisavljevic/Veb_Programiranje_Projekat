package com.vp_projekat.services;

import com.vp_projekat.DTOs.UserDTO;
import com.vp_projekat.beans.User;
import com.vp_projekat.beans.Users;
import org.springframework.stereotype.Service;

/**
 * Created by Lupus on 8/9/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User register(UserDTO userDTO){
        Users.load();
        User retUser = Users.getUser(userDTO.getUserName());
        if(retUser != null)
        {
            return null;
        }
        User newUser = new User(userDTO.getUserName(), userDTO.getPassword(), userDTO.getName(),
                userDTO.getLastName(), userDTO.getRole(), userDTO.getPhone(), userDTO.getEmail(),
                userDTO.getAddress(), userDTO.getPicture());

        Users.addUser(newUser);
        return  newUser ;
    }

}
