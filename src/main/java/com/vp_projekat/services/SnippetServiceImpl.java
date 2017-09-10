package com.vp_projekat.services;

import com.vp_projekat.DTOs.SnippetDTO;
import com.vp_projekat.beans.ProgrammingLanguages;
import com.vp_projekat.beans.Snippet;
import com.vp_projekat.beans.Snippets;
import com.vp_projekat.beans.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/15/2017.
 */

@Service
public class SnippetServiceImpl implements SnippetService {

    @Override
    public String createSnippet(SnippetDTO snippetDTO) {
        Snippets.load();
        if(!ProgrammingLanguages.getLanguage(snippetDTO.getProgrammingLanguage()))
        {
            snippetDTO.setProgrammingLanguage("undefined");
        }
        if(Users.getUser(snippetDTO.getUser().getUsername()) == null){
            return "BAD_REQUEST";
        }
        if(Users.getUser(snippetDTO.getUser().getUsername()).isBlocked())
        {
            return "BLOCKED";
        }
        Snippet newSnippet = new Snippet(snippetDTO.getDescription(), snippetDTO.getCode(),
                snippetDTO.getProgrammingLanguage(), snippetDTO.getRepository(), snippetDTO.getUser());

        Snippets.addSnippet(newSnippet);
        return  "OK" ;
    }

    @Override
    public Snippet removeSnippet(SnippetDTO snippetDTO) {
        if(Snippets.getSnippet(snippetDTO.getId()) != null) {
            System.out.println(snippetDTO.getId());
            return Snippets.deleteSnippet(snippetDTO.getId());
        }
        return  null;
    }

    @Override
    public Snippet blockSnippet(SnippetDTO snippetDTO) {
        Snippet current = Snippets.getSnippet(snippetDTO.getId());
        if(current != null) {
            System.out.println(current.isBlocked());
            current.setBlocked(true);

            Snippets.save();
            System.out.println(current.isBlocked());
            return current;
        }
        return  null;
    }

    @Override
    public Snippet unblockSnippet(SnippetDTO snippetDTO) {
        Snippet current = Snippets.getSnippet(snippetDTO.getId());
        if(current != null) {
            current.setBlocked(false);
            Snippets.save();
            return current;
        }
        return  null;
    }

    @Override
    public ArrayList<Snippet> getAll() {
        return Snippets.getSnippets();
    }
}
