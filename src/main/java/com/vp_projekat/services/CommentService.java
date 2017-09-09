package com.vp_projekat.services;

import com.vp_projekat.DTOs.CommentDTO;
import com.vp_projekat.DTOs.GradeDTO;
import com.vp_projekat.DTOs.SnippetDTO;
import com.vp_projekat.beans.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * Created by Lupus on 8/16/2017.
 */

@Service
public interface CommentService {
    String addComment(CommentDTO snippetDTO);

    Boolean removeComment(CommentDTO snippetDTO);

    String rateComment(GradeDTO gradeDTO);

    ArrayList<Comment> getAll(SnippetDTO snippetDTO);
}
