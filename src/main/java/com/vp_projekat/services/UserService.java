package com.vp_projekat.services;

import com.vp_projekat.DTOs.UserDTO;
import com.vp_projekat.beans.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/9/2017.
 */

@Service
public interface UserService {

    String register(UserDTO userDTO);

    User login(UserDTO userDTO);

    ArrayList<User> getAll();

    User block(UserDTO userDTO);

    User unblock(UserDTO userDTO);


}
