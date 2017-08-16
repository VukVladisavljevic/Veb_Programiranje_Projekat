package com.vp_projekat.services;

import com.vp_projekat.DTOs.CommentDTO;
import com.vp_projekat.DTOs.GradeDTO;
import com.vp_projekat.DTOs.SnippetDTO;
import com.vp_projekat.beans.Comment;
import com.vp_projekat.beans.Snippets;
import com.vp_projekat.beans.User;
import com.vp_projekat.beans.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/16/2017.
 */

@Service
public class CommentServiceImpl implements CommentService{

    @Override
    public Comment addComment(CommentDTO commentDTO) {

        User user = Users.getUser(commentDTO.getUser().getUsername());

        Comment comment = new Comment(commentDTO.getText(), commentDTO.getUser());
        Snippets.comment(comment, commentDTO.getSnippet());
        return comment;
    }

    @Override
    public Boolean removeComment(CommentDTO commentDTO) {
        Snippets.deleteComment(commentDTO.getId(), commentDTO.getSnippet());
        return true;
    }

    @Override
    public Boolean rateComment(GradeDTO gradeDTO) {
        User user = Users.getUser(gradeDTO.getUser().getUsername());
        if(user.getRole().equals("ANONIMUS"))
        {
            System.out.println( "BAD_REQUEST");
            return false;
        }
        if(user.isBlocked())
        {
            System.out.println( "BAD_REQUEST");
            return false;
        }
        Snippets.gradeComment(user, gradeDTO.getGrade(),
                gradeDTO.getSnippet(), gradeDTO.getComment());
        return true;
    }

    @Override
    public ArrayList<Comment> getAll(SnippetDTO snippetDTO) {
        return null;
    }
}
