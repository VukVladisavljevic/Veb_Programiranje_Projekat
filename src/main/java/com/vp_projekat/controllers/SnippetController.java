package com.vp_projekat.controllers;

import com.vp_projekat.DTOs.SnippetDTO;
import com.vp_projekat.beans.Snippet;
import com.vp_projekat.services.SnippetService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.ArrayList;

/**
 * Created by Lupus on 8/15/2017.
 */

@RestController
public class SnippetController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SnippetService snippetService;

    @RequestMapping(value="/api/snippet/create",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Snippet> create(@RequestBody SnippetDTO snippetDTO){
        logger.info("> create new snippet");

        Snippet retSnippet = snippetService.createSnippet(snippetDTO);

        if(retSnippet == null){
            System.out.println("Snippet not created");
            return new ResponseEntity<Snippet>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< snippet created");

        return new ResponseEntity<Snippet>(HttpStatus.OK);
    }

    @RequestMapping(value="/api/snippet/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Snippet> delete(@RequestBody SnippetDTO snippetDTO){
        logger.info("> delete snippet");

        Snippet retSnippet = snippetService.removeSnippet(snippetDTO);

        if(retSnippet == null){
            System.out.println("Snippet not removed");
            return new ResponseEntity<Snippet>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< snippet removed");

        return new ResponseEntity<Snippet>(HttpStatus.OK);
    }

    @RequestMapping(value="/api/snippet/block",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Snippet> block(@RequestBody SnippetDTO snippetDTO){
        logger.info("> block snippet");

        Snippet retSnippet = snippetService.blockSnippet(snippetDTO);

        if(retSnippet == null){
            System.out.println("Snippet not blocked");
            return new ResponseEntity<Snippet>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< snippet blocked");

        return new ResponseEntity<Snippet>(HttpStatus.OK);
    }

    @RequestMapping(value="/api/snippet/unblock",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Snippet> unblock(@RequestBody SnippetDTO snippetDTO){
        logger.info("> block snippet");

        Snippet retSnippet = snippetService.unblockSnippet(snippetDTO);

        if(retSnippet == null){
            System.out.println("Snippet unblocked");
            return new ResponseEntity<Snippet>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< snippet unblocked");

        return new ResponseEntity<Snippet>(HttpStatus.OK);
    }

    @RequestMapping(value="/api/snippet/getAll",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Snippet>> getAllSnippets(){
        logger.info("> get snippets");

        ArrayList<Snippet> retList = snippetService.getAll();

        if(retList == null){
            System.out.println("Snippet not got");
            return new ResponseEntity< ArrayList<Snippet>>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< snippets got");

        return new ResponseEntity< ArrayList<Snippet>>(HttpStatus.OK);
    }

}
