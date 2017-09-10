package com.vp_projekat.controllers;

import com.vp_projekat.DTOs.UserDTO;
import com.vp_projekat.beans.ProgrammingLanguages;
import com.vp_projekat.beans.Snippets;
import com.vp_projekat.beans.User;
import com.vp_projekat.beans.Users;
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

import java.util.ArrayList;

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
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {

        logger.info("> register  user");

        String retuser = userService.register(userDTO);

        if (retuser == null) {
            System.out.println(" User not created");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< register user");
        System.out.println("User successfully created");

        return new ResponseEntity<>(retuser, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/loadData",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> loadData() {

        logger.info("> register  user");
        Users.load();
        ProgrammingLanguages.load();
        Snippets.load();
        logger.info("< register user");
        System.out.println("User successfully loaded");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> login(@RequestBody UserDTO userDTO) {

        logger.info("> login  user");
        System.out.println(userDTO.getUsername().equals("guest"));
        User retuser = userService.login(userDTO);

        if (retuser == null) {
            System.out.println(" User not existing");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< user logged in");
        System.out.println("User successfully logged");

        return new ResponseEntity<>(retuser, HttpStatus.OK);
    }

    @RequestMapping(value="/api/users/getAll",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<User>> getAllUsers(){
        logger.info("> get users");

        ArrayList<User> retList = userService.getAll();

        if(retList == null){
            System.out.println("users not got");
            return new ResponseEntity< ArrayList<User>>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< users got");

        return new ResponseEntity< ArrayList<User>>(retList, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users/block",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> block(@RequestBody UserDTO userDTO) {

        logger.info("> block  user");

        User retuser = userService.block(userDTO);

        if (retuser == null) {
            System.out.println(" User not block");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< block user");
        System.out.println("User successfully block");

        return new ResponseEntity<>(retuser, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users/unblock",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> unblock(@RequestBody UserDTO userDTO) {

        logger.info("> unblock  user");

        User retuser = userService.unblock(userDTO);

        if (retuser == null) {
            System.out.println(" User not unblock");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< unblock user");
        System.out.println("User successfully unblock");

        return new ResponseEntity<>(retuser, HttpStatus.OK);
    }


}
