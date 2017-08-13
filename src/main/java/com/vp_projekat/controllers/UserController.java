package com.vp_projekat.controllers;

import com.vp_projekat.DTOs.UserDTO;
import com.vp_projekat.beans.User;
import com.vp_projekat.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lupus on 8/9/2017.
 */

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> register(@RequestBody UserDTO userDTO) {

        logger.info("> register  user");

        User retuser = userService.register(userDTO);

        if (retuser == null) {
            System.out.println(" User not created");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< register user");
        System.out.println("User successfully created");

        return new ResponseEntity<>(retuser, HttpStatus.OK);
    }



}
