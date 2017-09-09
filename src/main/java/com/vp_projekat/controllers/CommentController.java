package com.vp_projekat.controllers;

import com.vp_projekat.DTOs.CommentDTO;
import com.vp_projekat.DTOs.GradeDTO;
import com.vp_projekat.DTOs.SnippetDTO;
import com.vp_projekat.beans.Comment;
import com.vp_projekat.beans.Snippet;
import com.vp_projekat.services.CommentService;
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
public class CommentController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/api/snippet/comment/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addComment(@RequestBody CommentDTO commentDTO){
        logger.info("> create new comment");

        String retComment = commentService.addComment(commentDTO);

        if(retComment == null){
            System.out.println("comment not created");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< snippet created");

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value="/api/snippet/comment/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteComment(@RequestBody CommentDTO commentDTO){
        logger.info("> delete comment");

        Boolean retComment = commentService.removeComment(commentDTO);

        if(retComment == null){
            System.out.println("comment not removed");
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< comment removed");

        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }

    @RequestMapping(value="/api/snippet/comment/rate",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> rateComment(@RequestBody GradeDTO gradeDTO){
        logger.info("> rate comment");

        String retComment = commentService.rateComment(gradeDTO);

        if(retComment == null){
            System.out.println("Snippet not rated");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        logger.info("< snippet rated");

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
