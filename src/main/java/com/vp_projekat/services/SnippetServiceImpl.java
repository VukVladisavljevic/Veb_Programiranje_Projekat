package com.vp_projekat.services;

import com.vp_projekat.DTOs.SnippetDTO;
import com.vp_projekat.beans.Snippet;
import com.vp_projekat.beans.Snippets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Lupus on 8/15/2017.
 */

@Service
public class SnippetServiceImpl implements SnippetService {

    @Override
    public Snippet createSnippet(SnippetDTO snippetDTO) {
        Snippets.load();
        Snippet retSnippet = Snippets.getSnippet(snippetDTO.getId());
        if(retSnippet != null)
        {
            return null;
        }
        Snippet newSnippet = new Snippet(snippetDTO.getDescription(), snippetDTO.getCode(),
                snippetDTO.getProgrammingLanguage(), snippetDTO.getRepository(), snippetDTO.getUser());

        Snippets.addSnippet(newSnippet);
        return  newSnippet ;
    }

    @Override
    public Snippet removeSnippet(SnippetDTO snippetDTO) {
        if(Snippets.getSnippet(snippetDTO.getId()) != null) {
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
