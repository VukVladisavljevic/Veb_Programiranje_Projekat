package com.vp_projekat.services;

import com.vp_projekat.DTOs.UserDTO;
import com.vp_projekat.beans.User;
import org.springframework.stereotype.Service;

/**
 * Created by Lupus on 8/9/2017.
 */

@Service
public interface UserService {

    public User register(UserDTO userDTO);
}
