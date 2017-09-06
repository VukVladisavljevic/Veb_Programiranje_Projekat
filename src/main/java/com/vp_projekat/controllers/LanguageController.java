package com.vp_projekat.controllers;

import com.vp_projekat.DTOs.LanguageDTO;
import com.vp_projekat.beans.ProgrammingLanguages;
import com.vp_projekat.beans.Snippet;
import com.vp_projekat.services.LanguageService;
import com.vp_projekat.services.SnippetService;
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
 * Created by Lupus on 8/16/2017.
 */

@RestController
public class LanguageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LanguageService languageService;

    @RequestMapping(value="/api/language/getAll",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<String>> getAllLanguages(){
        logger.info("> get languages");

        ArrayList<String> retList = languageService.getAll();

        if(retList == null){
            System.out.println("languages not got");
            return new ResponseEntity< ArrayList<String>>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< languages got");

        return new ResponseEntity< ArrayList<String>>(retList, HttpStatus.OK);
    }

    @RequestMapping(value="/api/language/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> create(@RequestBody LanguageDTO languageDTO){
        logger.info("> create new snippet");

        Boolean success = languageService.addLanguage(languageDTO.getLanguageName());

        if(!success){
            System.out.println("Snippet not created");
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< snippet created");

        return new ResponseEntity<Boolean>(success, HttpStatus.OK);
    }

}
